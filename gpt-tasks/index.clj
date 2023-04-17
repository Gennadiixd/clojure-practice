;; students-over-credits: Write a function that takes the students list 
;; and a credit threshold, and returns a list of student names who are 
;; enrolled in more than the given number of credits.

(def students
  [{:name "Alice" :courses [{:id "CS101" :credits 3} {:id "MATH101" :credits 4}]}
   {:name "Bob" :courses [{:id "CS101" :credits 3}]}
   {:name "Charlie" :courses [{:id "MATH101" :credits 4} {:id "PHYS101" :credits 4}]}
   {:name "David" :courses [{:id "CS101" :credits 3} {:id "PHYS101" :credits 4} {:id "MATH101" :credits 4}]}])

(prn (#(+ 6 %) 2))
