(ns project-info.core
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [tentacles.repos :as repos]))

(defn repos []
  (repos/org-repos "clj-commons"))


(defn clojars-artifacts []
  (-> "https://clojars.org/api/groups/clj-commons"
      http/get
      :body
      (json/decode true)))

(defn clojars-info [artifacts]
  (clojure.pprint/print-table [:jar_name :user :downloads] artifacts))


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
