;; gorilla-repl.fileformat = 1

;; **
;;; Functions
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
;; defining functions
;; use defn unless you absolutely need to feel different
;; Function definitions are composed of 5 things
;; `defn`
;; function name
;; doc string
;; arguments
;; what it do
(defn my-fn
  "This is my functions documentation"
  [arg-1 arg-2]
  (prn arg-1 arg-2))

(my-fn 1 "Hello")
;; @@
;; ->
;;; 1 &quot;Hello&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; clojure functions can have multiple arities
(defn multi-ar-fn
  ([]
   (prn "There's nothing here"))
  ([item]
   (prn (format "You're holding a %s" item)))
  ([item loc]
   (prn (format "You're holding a %s in your %s" item loc))))

(multi-ar-fn)
(multi-ar-fn "sword")
(multi-ar-fn "crack pipe" "pocket")

;; if you have a drug problem, there is help out there
;; @@
;; ->
;;; &quot;There&#x27;s nothing here&quot;
;;; &quot;You&#x27;re holding a sword&quot;
;;; &quot;You&#x27;re holding a crack pipe in your pocket&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; arity overloading is a good way to provide default args
;; as a style note, lead with the non-default arity
(defn move
  ([method loc]
   (prn (format "You %s to %s" method loc)))
  ([loc]
   (move "run" loc)))

(move "walk" "the park")
(move "get away from your ex")
;; @@
;; ->
;;; &quot;You walk to the park&quot;
;;; &quot;You run to get away from your ex&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; rest
;; for when you have a variable number of args
(defn greeting [name]
  (format "Hello %s" name))

(defn greetings-vec [names]
  (map greeting names))

(defn greetings-rest [& names] ;; note the & before the arg
  (map greeting names))

(greetings-vec ["Derek Jeter" "Lilo & Stitch"])
(greetings-rest "Dave" "Sami" "Mark Johnson")

;; you can only have one instance of the & in a fn def
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;Hello Dave&quot;</span>","value":"\"Hello Dave\""},{"type":"html","content":"<span class='clj-string'>&quot;Hello Sami&quot;</span>","value":"\"Hello Sami\""},{"type":"html","content":"<span class='clj-string'>&quot;Hello Mark Johnson&quot;</span>","value":"\"Hello Mark Johnson\""}],"value":"(\"Hello Dave\" \"Hello Sami\" \"Hello Mark Johnson\")"}
;; <=

;; @@
;; destructuring
;; don't do it that much, it gets messy
(defn dumb-point->str [point]
  (str (first point) " - " (last point)))

(defn smart-point->str [[x y]]
  (str x " - " y))

(dumb-point->str [1 2])
(smart-point->str [3 5])

;; here's the guide for more, https://clojure.org/guides/destructuring
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;3 - 5&quot;</span>","value":"\"3 - 5\""}
;; <=

;; @@
;; function body
;; the last expression is returned
(defn bad-example-fn []
  (+ 1 1)
  "Hello"
  :key-word
  "SLAM!")

(bad-example-fn)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;SLAM!&quot;</span>","value":"\"SLAM!\""}
;; <=

;; @@
;; same goes for functions using special forms
(defn another-example-fn [x]
  (if (> x 0)
    "Do a thing"
    "Don't do a thing"))

(another-example-fn 1)
(another-example-fn -1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Don&#x27;t do a thing&quot;</span>","value":"\"Don't do a thing\""}
;; <=

;; @@
;; anonymous functions
;; (defn name [] ...) == (def name (fn [] ...))
;; use the fn macro to define an anonymous function
(fn [& args]
  9000)

;; they're useful for things like map
(map (fn [x] (+ 9000 x)) [1 2 500])

(def plus-9000 (fn [x] (+ 9000 x)))
(plus-9000 42)

(map plus-9000 [10 20 30])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>9010</span>","value":"9010"},{"type":"html","content":"<span class='clj-long'>9020</span>","value":"9020"},{"type":"html","content":"<span class='clj-long'>9030</span>","value":"9030"}],"value":"(9010 9020 9030)"}
;; <=

;; @@
;; you can also use the funky syntax
#(+ 9000 %)

;; it's good for cutting down key strokes
(map #(str %1) [1 2 3 4])

;; the # tells the reader that the thing following it is
;; an anonymous function
;; the % defines args %, %1, %2, ... %n
(#(str %1 " and " %2) "Clojure" "you")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Clojure and you&quot;</span>","value":"\"Clojure and you\""}
;; <=

;; @@
;; returning functions
(defn adder [amt]
  (fn [x] (+ amt x)))

(def add-5 (adder 5))

(add-5 10)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>15</span>","value":"15"}
;; <=
