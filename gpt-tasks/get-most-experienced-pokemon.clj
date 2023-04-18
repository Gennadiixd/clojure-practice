;; Your next task is to create a function that, given a list of Pokémon names, 
;; fetches their base experience and returns the name of the Pokémon with 
;; the highest base experience.

(require '[clj-http.client :as client])
(require '[cheshire.core :as json])

(defn get-data [url]
  (let [response (client/get url)]
    (json/parse-string (:body response))))

(def pokemon-api-url "https://pokeapi.co/api/v2/")
(def get-pokemon-url (str pokemon-api-url "pokemon/"))

(defn fetch-pokemon-by-name [pokemon-name] (get-data (str get-pokemon-url pokemon-name)))

(def pokemon-names ["ditto" "pikachu" "charmander" "bulbasaur" "squirtle" "mewtwo" "mew"])

(def default-accumulator {"base_experience" 0})
(prn (reduce
      (fn [acc value]
        (if (> (get value "base_experience") (get acc "base_experience")) value acc))
      {"base_experience" 0}
      (map #(fetch-pokemon-by-name %) pokemon-names)))

(prn (reduce
      (fn [acc value]
        (assoc acc "base_experience" (+ (get acc "base_experience") (get value "base_experience"))))
      default-accumulator
      (map #(fetch-pokemon-by-name %) pokemon-names)))

