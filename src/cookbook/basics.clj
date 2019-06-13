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
(ns crashcourse
  (:require [gorilla-plot.core :as plot]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; forms
1
"Hello"
['s' \S 1.0 :foo]
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>s&#x27;</span>","value":"s'"},{"type":"html","content":"<span class='clj-char'>\\S</span>","value":"\\S"},{"type":"html","content":"<span class='clj-double'>1.0</span>","value":"1.0"},{"type":"html","content":"<span class='clj-keyword'>:foo</span>","value":":foo"}],"value":"[s' \\S 1.0 :foo]"}
;; <=

;; @@
;; s-expressions
;; (function arg-1 arg-2 arg-3)
(+ 1 2 3 4 5)
(str "Hello " "Dave " "and " "Sami!")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Hello Dave and Sami!&quot;</span>","value":"\"Hello Dave and Sami!\""}
;; <=

;; @@
;; if
(if (= 1 2)
  (prn "They're equal")
  (prn "Damn..."))
;; @@
;; ->
;;; &quot;Damn...&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; do
(do (prn "Do something")
    (prn "Do something else")
  	"Return the last value")
;; @@
;; ->
;;; &quot;Do something&quot;
;;; &quot;Do something else&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Return the last value&quot;</span>","value":"\"Return the last value\""}
;; <=

;; @@
;; when
(when true
  (prn "Truth will out!")
  "We're done here")
;; @@
;; ->
;;; &quot;Truth will out!&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;We&#x27;re done here&quot;</span>","value":"\"We're done here\""}
;; <=

;; @@
;; truthiness
(defn truthy? [x]
  (if x
    true
    false))

(truthy? nil)
(truthy? true)
(truthy? false)
(truthy? 0)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; =
(= 1 1)
(= 1 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}
;; <=

;; @@
;; and or
(and true false)
(or true false)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
;; naming vals
(def foo "I am foo")
foo
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;I am foo&quot;</span>","value":"\"I am foo\""}
;; <=

;; @@
;; functions
(defn function-name [arg-1 arg-2]
  (prn (format "Do some stuff here with %s and %s" arg-1 arg-2)))

(function-name "args" "whatnot")
;; @@
;; ->
;;; &quot;Do some stuff here with args and whatnot&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; putting this all together
(defn err-msg
  [severity]
  (if (= severity :mild)
    "I'm mildly inconvenienced"
    "Damn..."))

(def mild-err (err-msg :mild))
mild-err

(def bad-err (err-msg "anything else"))
bad-err
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Damn...&quot;</span>","value":"\"Damn...\""}
;; <=

;; @@

;; @@
