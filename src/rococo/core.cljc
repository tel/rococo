(ns rococo.core
  "CSS of a kind."
  (:refer-clojure :exclude [and -> >])
  (:require
    #?(:cljs [goog.style])
    [garden.core :as garden]
    [clojure.string]))

(defn mangle-symbol [sym]
  (str (clojure.string/replace (namespace sym) #"\." "_") "--" (name sym)))

(defn expand-css-spec [[sel spec]]
  (let [sels (if (vector? sel) sel [sel])
        specs (if (vector? spec) spec [spec])]
    (into sels specs)))

(defn css-for-class [name css-map]
  (into [(str "." name)] (map expand-css-spec) css-map))

(def *defined-classes* (atom {}))
(def *defined-animations* (atom {}))

(defn total-css
  [& {:keys [pretty-print? base-styles vendors auto-prefix]
      :or {base-styles []
           pretty-print? false
           vendors ["webkit"]
           auto-prefix #{:border-radius}}}]
  (let [defined-classes (into []
                              (map (fn [[k v]] (css-for-class k v)))
                              @*defined-classes*)
        defined-animations (into [] (vals @*defined-animations*))]
    (garden/css
      {:pretty-print? pretty-print?
       :vendors vendors
       :auto-prefix auto-prefix}
      (concat [base-styles] defined-animations defined-classes))))

#?(:cljs (defn inject-styles [styles]
           (goog.style/installStyles styles)))

#?(:clj (defn get-symbol [class-name]
          (symbol (str *ns*) (str class-name))))

#?(:clj (defmacro defclass [class-name prop-map]
          `(let [sym# '~(get-symbol class-name)
                 name# (rococo.core/mangle-symbol sym#)]
             (swap! *defined-classes* assoc name# ~prop-map)
             (def ~class-name name#))))

#?(:clj (defmacro defkeyframes [keyframes-name & rules]
          `(let [sym# '~(get-symbol keyframes-name)
                 name# (rococo.core/mangle-symbol sym#)
                 rule# (garden.types/->CSSAtRule
                          :keyframes
                          {:identifier name#
                           :frames [~@rules]})]
             (swap! *defined-animations* assoc name# rule#)
             (def ~keyframes-name name#))))
