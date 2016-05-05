(defproject rococo "0.1.0-SNAPSHOT"
  :description "A little library for CSS modules atop Garden"
  :url "http://github.com/tel/rococo"
  :license  {:name "BSD 3-clause"
             :url  "http://opensource.org/licenses/BSD-3-Clause"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]
                 [garden "1.3.2"]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
