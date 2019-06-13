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
(ns data-structures)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; numbers
10
1.5
2/3 ;; note that this doesn't return a decimal
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>2/3</span>","value":"2/3"}
;; <=

;; @@
;; strings
"Hello there Dave!"
"Hello there Sami!"
"Do you hate Clojure yet!?"
(str "I hope not" ", " "we have way more to go here!")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;I hope not, we have way more to go here!&quot;</span>","value":"\"I hope not, we have way more to go here!\""}
;; <=

;; @@
;; Maps
;; your new best friend whether you like it or not
{}
{:first-name "James"
 :last-name "Bond"}

{"add" +}

{:name {:first "harold" :middle "james" :last "potter"}}

(hash-map :a 1 :b 2)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:b</span>","value":":b"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"[:b 2]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[:a 1]"}],"value":"{:b 2, :a 1}"}
;; <=

;; @@
(get {:a 1 :b 2} :b)

(:a {:a 1 :b 2})

(get-in {:a 0 :b {:c "foo"}} [:b :c])

(:key-not-there {:a 1 :b 3} "Damn...")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Damn...&quot;</span>","value":"\"Damn...\""}
;; <=

;; @@
;; Keywords
;; they're great for namspacing and map keys
:a 
:b
:gandalf
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:gandalf</span>","value":":gandalf"}
;; <=

;; @@
;; Vectors
;; Not your best friend, but damn close
[1 2 3]

[1 [2 3] 4]

(vector :a \b "c")
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:a</span>","value":":a"},{"type":"html","content":"<span class='clj-char'>\\b</span>","value":"\\b"},{"type":"html","content":"<span class='clj-string'>&quot;c&quot;</span>","value":"\"c\""}],"value":"[:a \\b \"c\"]"}
;; <=

;; @@
(get [1 2 3] 0)

(get [1 {:name "Bilbo"} 2] 1)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Bilbo&quot;</span>","value":"\"Bilbo\""}],"value":"[:name \"Bilbo\"]"}],"value":"{:name \"Bilbo\"}"}
;; <=

;; @@
;; conj, conjoin
;; vectors are added to at the end
(conj [1 2 3] 4)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"[1 2 3 4]"}
;; <=

;; @@
;; lists
;; proceed with caution if you think a list is the way to go
'(1 2 3 4)

;; you can also use the list function
(list \a \b \c \d)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-char'>\\a</span>","value":"\\a"},{"type":"html","content":"<span class='clj-char'>\\b</span>","value":"\\b"},{"type":"html","content":"<span class='clj-char'>\\c</span>","value":"\\c"},{"type":"html","content":"<span class='clj-char'>\\d</span>","value":"\\d"}],"value":"(\\a \\b \\c \\d)"}
;; <=

;; @@
;; since clojure code is written as lists, you put a \' in
;; front. this tells the compiler that it's a literal and
;; not code to be executed.
;; uncomment the next line and execute it to see what happens
(1 2 3)
;; @@

;; @@
(nth '(1 2 3) 0)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}
;; <=

;; @@
;; conj, adds to the front on lists
(conj '(1 2 3) 4)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"(4 1 2 3)"}
;; <=

;; @@
(comment
 
READ THIS YO
 
When should you use a list and when should you use a vector? A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list. Otherwise, you should use a vector. As you learn more, you’ll get a good feel for when to use which.
 
)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; sets, no duplicates, no order, just chaos
#{1 2 3}

(hash-set \a \a \b \b \c \c) ;; hash-set takes a bunch of args

(set [10 10 20 20]) ;; set takes a __collection__ of args
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"#{20 10}"}
;; <=

;; @@
;; conj
(conj #{2 3} 1)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"#{1 3 2}"}
;; <=

;; @@
;; containment and access
(contains? #{1 2 3 4} 3) ;; use with if
(contains? #{1 2 3 4} 5)

(:a #{:a :b}) ;; use if you plan to use the data eventually
(:c #{:a :b})

(get #{:a "b"} "b")
(get #{:a "b"} 1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Use Clojure folks are simple people
;; We prefer to have 100 functions working on 1 data structure
;; rather than have 10 functions working on 10 data structures
;; It hurts our brains less
;;
;; However, we can make new data types, objects, etc...
;; But that's pretty intermediate/advanced stuff
;; so we'll get to that later
;; @@
