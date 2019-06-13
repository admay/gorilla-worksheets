;; gorilla-repl.fileformat = 1

;; @@
(comment 
 
Shift + enter evaluates code. 
Hit alt+g twice in quick succession or click the menu icon [upper-right corner] for more commands.

This namespace is for the very basics of Clojure.
We'll go over,
1. basic forms
2. how to write and s-expression
3. if, do, when
4. truthiness
5. and, or
6. naming values
7. defining functions
 
)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(ns crashcourse
  (:require [gorilla-plot.core :as plot]))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; forms
1 ;; number
"Hello" ;; string
['s' \S 1.0 :foo] ;; this is a vectory, clj's second best friend
'(1 2 3) ;; this is a basic list, we won't use these too much
{:key "val", :other-key "other val"} ;; this is a map, clj's best friend
#{:this :is :a :set :no :duplicates :allowed} ;; add a duplicate :a and watch
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:duplicates</span>","value":":duplicates"},{"type":"html","content":"<span class='clj-keyword'>:is</span>","value":":is"},{"type":"html","content":"<span class='clj-keyword'>:this</span>","value":":this"},{"type":"html","content":"<span class='clj-keyword'>:set</span>","value":":set"},{"type":"html","content":"<span class='clj-keyword'>:no</span>","value":":no"},{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-keyword'>:allowed</span>","value":":allowed"}],"value":"#{:duplicates :is :this :set :no :a :allowed}"}
;; <=

;; @@
;; s-expressions, how we do Clojure
;; (function arg-1 arg-2 arg-3)
(+ 1 2 3 4 5)
(str "Hello " "Dave " "and " "Sami!")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Hello Dave and Sami!&quot;</span>","value":"\"Hello Dave and Sami!\""}
;; <=

;; @@
;; if statements
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
;; do blocks
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
;; when statements
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
;; how do these act as the condition of an `if` statement
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
;; equality
(= 1 1)
(= 1 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}
;; <=

;; @@
;; and/or
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
;; how to use them
;; and how to define them
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
  "Returns an error message based on the provided severity"
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
(comment

All Clojure functions are called in the same way
(function arg-1 arg-2 ... etc)
 
It's part of Clojure's commitment to simplicity
There are no in-fix functions in Clojure like in Java and Python
 
e.g. 2 + 2 
 
There are also no function chains

e.g. "string".upper().replace("i", " - I - ").split("")
 
What you can do is compose them like so,
 
(split (replace (upper "string") "i" " -I - "))

Code style is very important to maintain due to the density of Clojure. So make sure to keep things nice and clean

)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=
