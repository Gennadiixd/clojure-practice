(require '[clj-http.client :as client])
(require '[cheshire.core :as json])

(defn get-data [url]
  (let [response (client/get url)]
    (json/parse-string (:body response))))

(def pokemon-api-url "https://pokeapi.co/api/v2/")
(def get-pokemon-url (str pokemon-api-url "pokemon/"))

(defn fetch-pokemon-by-name [pokemon-name] (get-data (str get-pokemon-url pokemon-name)))

(defn display-pokemon-info [pokemon-name]
  (let [pokemon (fetch-pokemon-by-name pokemon-name)
        pokemon-types (map #(get-in % ["type" "name"]) (get pokemon "types"))]
    (str "pokemon types are - " (reduce (fn [acc value] (str acc (if (empty? acc) "" ", ") value)) "" pokemon-types) ", pokemon name is - " (get pokemon "name") ", pokemon height is - " (get pokemon "height") ", pokemon weight is - " (get pokemon "weight") ", pokemon id is - " (get pokemon "id"))))

(prn (display-pokemon-info "ditto"))
