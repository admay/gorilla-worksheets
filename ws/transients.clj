;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns tropical-marsh)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Transient data structures are used for speeding up Clojure. Immutable data structures and pure functions are great for readability but they aren't as performant. Internally, Clojure will mutate small and newly allocated arrays that build the data structures we work with. The rest of the code doesn't 'see' any of these changes, so it's a safe operation.
;; At a higher level, we can do the same with our data structures in our code to prevent bottlenecks. That's why we use transients.
;; @@

;; @@
;; Create transient versions of datastructures using transient
(def a (transient [1 2 3]))
a
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[clojure.lang.PersistentVector$TransientVector 0x72eaaf1d &quot;clojure.lang.PersistentVector$TransientVector@72eaaf1d&quot;]</span>","value":"#object[clojure.lang.PersistentVector$TransientVector 0x72eaaf1d \"clojure.lang.PersistentVector$TransientVector@72eaaf1d\"]"}
;; <=

;; @@
;; compare this to a regular array
(def b [1 2 3])
b
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"[1 2 3]"}
;; <=

;; @@
;; they're much faster than regular data structures
(defn vrange [n]
  (loop [i 0 v []]
    (if (< i n)
      (recur (inc i) (conj v i))
      v)))

(defn vrange2 [n]
  (loop [i 0 v (transient [])]
    (if (< i n)
      (recur (inc i) (conj! v i))
      (persistent! v))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;tropical-marsh/vrange2</span>","value":"#'tropical-marsh/vrange2"}
;; <=

;; @@
(time (def v (vrange 1000000)))
;; avergae time between 60 and 70 msecs
;; @@
;; ->
;;; &quot;Elapsed time: 62.2931 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;tropical-marsh/v</span>","value":"#'tropical-marsh/v"}
;; <=

;; @@
(time (def v2 (vrange2 1000000)))
;; average time around 40 msecs
;; @@
;; ->
;;; &quot;Elapsed time: 40.7233 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;tropical-marsh/v2</span>","value":"#'tropical-marsh/v2"}
;; <=

;; @@
;; Something to be weary of, transients require thread isolation. The mutation involved with transients causes errors when multiple threads are operating on them. For thread safe data structures, use atoms or refs.
;; Something else to keep in mind, get all of your ops done on the transient in one big sweep. Overuse of conversion will lead to performance decrease, just like any other datastructure.
;; @@
