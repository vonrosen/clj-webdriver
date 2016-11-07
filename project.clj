(defproject vonrosen/clj-webdriver "0.7.3"
  :description "Clojure API for Selenium-WebDriver"
  :url "https://github.com/semperos/clj-webdriver"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :global-vars {*warn-on-reflection* true}
  :dependencies [[org.clojure/core.cache "0.6.4"]
                 [org.clojure/tools.logging "0.2.3"]
                 [clj-http "2.0.0"]
                 [cheshire "5.5.0"]
                 [org.mortbay.jetty/jetty "6.1.25"]]
  :deploy-repositories [["releases" :clojars]]
  :jar-exclusions [#".*\.html" #"^public/"]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.7.0"]
                                  [org.clojure/tools.reader "0.10.0-alpha3"]
                                  [org.slf4j/slf4j-log4j12 "1.7.5"]
                                  [com.stuartsierra/component "0.2.3"]
                                  [ring/ring-jetty-adapter "1.4.0"]
                                  [enlive "1.0.0" :exclusions [org.clojure/clojure]]
                                  [net.cgrand/moustache "1.0.0" :exclusions [org.clojure/clojure ring/ring-core]]
                                  ;; Needed by "remote" code                                  
                                  [org.seleniumhq.selenium/selenium-server "2.53.0"]
                                  ;; Needed by core code
                                  [org.seleniumhq.selenium/selenium-java "2.53.0"]
                                  [org.seleniumhq.selenium/selenium-firefox-driver "2.53.0"]
                                  [org.seleniumhq.selenium/selenium-api "2.53.0"]
                                  [org.seleniumhq.selenium/selenium-remote-driver "2.53.0"]                                  
                                  [com.codeborne/phantomjsdriver "1.2.1"
                                   :exclusion [org.seleniumhq.selenium/selenium-java
                                               org.seleniumhq.selenium/selenium-server
                                               org.seleniumhq.selenium/selenium-remote-driver]]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}}
  :scm {:url "git@github.com:semperos/clj-webdriver.git"}
  :pom-addition [:developers [:developer [:name "Daniel Gregoire"]]]
  :test-selectors {:default (complement (some-fn :manual-setup :saucelabs))
                   :manual-setup :manual-setup
                   :saucelabs :saucelabs
                   :ci (complement (some-fn :chrome :manual-setup :saucelabs))
                   :all (fn [m] true)})
