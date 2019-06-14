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
(ns functions-in-depth)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Remember, all Clojure functions are called in the same way
;; opening paren, operator, operands, closing paren
;; these can be nested to any depth needed, however there are tools
;; and well documented patterns/practices to prevent your code from
;; becoming too dense to read
;; @@

;; @@
;; we're able to write some pretty interesting code in Clojure
((or + -) 1 2 3)

((and (= 1 1) +) 2 4 6)

((first [+ *]) 1 3 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>9</span>","value":"9"}
;; <=

;; @@
;; If you get an error like,
;; `ClassCastException java.lang.String cannot be cast to clojure.lang.IFn user/eval728 (NO_SOURCE_FILE:1)`
;; That means you tried to call something as a function that isn't a function
;; (1 2 3 4) or ("string" 1 2 3)
;; @@

;; @@
;; In Clojure, functions can take anything in Clojure as an argument
;; inclouding other functions, anonymous functions, and macros
(map inc [1 2 4])

(map #(* 2 %) [2 4 6])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"}],"value":"(4 8 12)"}
;; <=

;; **
;;; READ THIS YO
;;;  
;;; Clojure's support for higher order functions allows for you to abstract
;;; operations over collections, processes, and objects.
;;; It's one of Clojure's most powerful tools in creating lean code.
;;; It's also one of the more difficult transitions to make when learning the language.
;;;  
;;; When you're working in Clojure, it's important to learn to see data as a whole rather
;;; than as individual elements.
;;; 
;;; The process of incrementing each element in a vector of numbers by 1 like so,
;;; ```
;;; numbers = [1, 2, 3, 4]
;;; incremented_numbers = []
;;; for (int x in numbers) {
;;; 	x = x + 1 
;;;  	incremented_numbers.push(x)
;;; }
;;; ```
;;;  
;;; Think of it as, I want to apply a function to a collection,
;;; 
;;; ```
;;; (def numbers [1 2 3 4])
;;; (def incremented-numbers (map inc numbers))
;;; ```
;;; 
;;; The distinction might seem obvious at first.
;;; It may also seem like there isn't really a distinction to be made there.
;;; The concept will click eventually.
;;; Just always keep in mind that in Clojure, we operate on data a whole.
;; **

;; **
;;; The last detail that you need know about function calls is that Clojure evaluates all function arguments recursively before passing them to the function. 
;;; 
;;; Here’s how Clojure would evaluate a function call whose arguments are also function calls:
;;; 
;;; ```
;;; (+ (inc 199) (/ 100 (- 7 2)))
;;; (+ 200 (/ 100 (- 7 2))) ; evaluated "(inc 199)"
;;; (+ 200 (/ 100 5)) ; evaluated (- 7 2)
;;; (+ 200 20) ; evaluated (/ 100 5)
;;; 220 ; final evaluation
;;; ```
;; **

;; @@

;; @@
