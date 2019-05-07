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
(ns undisturbed-farm)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; you can use core java classes by default
;; @@

;; @@
String
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-class'>java.lang.String</span>","value":"java.lang.String"}
;; <=

;; @@
(defn date? [d] (instance? java.util.Date d))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;undisturbed-farm/date?</span>","value":"#'undisturbed-farm/date?"}
;; <=

;; @@
(.getEnclosingClass java.util.Map$Entry)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-class'>java.util.Map</span>","value":"java.util.Map"}
;; <=

;; @@
;; you can use the below approaches for accessing class methods and fields
;; they all expand into the . special form
;; @@

;; @@
(.toUpperCase "Hello")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;HELLO&quot;</span>","value":"\"HELLO\""}
;; <=

;; @@
(.getName String) ;; for fields & methods
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;java.lang.String&quot;</span>","value":"\"java.lang.String\""}
;; <=

;; @@
(.-x (java.awt.Point. 1 2)) ;; for fields
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}
;; <=

;; @@
(System/getProperty "java.vm.version") ;; for statics
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;25.212-b04&quot;</span>","value":"\"25.212-b04\""}
;; <=

;; @@
Math/PI
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>3.141592653589793</span>","value":"3.141592653589793"}
;; <=

;; @@
(. Math PI) ;; expanded . special form
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>3.141592653589793</span>","value":"3.141592653589793"}
;; <=

;; @@
(. (. System (getProperties)) (get "os.name")) ;; you can use a double dot for secondary expansion
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Linux&quot;</span>","value":"\"Linux\""}
;; <=

;; @@
(-> (System/getProperties) (.get "os.name")) ;;this is easier
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Linux&quot;</span>","value":"\"Linux\""}
;; <=

;; @@
(doto (new java.util.HashMap)
           (.put "a" 1)
           (.put "b" 2))
;; doto will call all provided methods on the provided instance of a thing
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>{&quot;a&quot; 1, &quot;b&quot; 2}</span>","value":"{\"a\" 1, \"b\" 2}"}
;; <=

;; @@
(def my-map (new java.util.HashMap))

(doto my-map 
  (.put "foo" "bar")
  (.put "baz" "bang"))

my-map
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>{&quot;foo&quot; &quot;bar&quot;, &quot;baz&quot; &quot;bang&quot;}</span>","value":"{\"foo\" \"bar\", \"baz\" \"bang\"}"}
;; <=

;; @@
;; Alternative macro syntax
(new java.lang.String "Hello")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Hello&quot;</span>","value":"\"Hello\""}
;; <=

;; @@
(java.lang.String. "Hello") ;; note the dot
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;Hello&quot;</span>","value":"\"Hello\""}
;; <=

;; @@
;; determining if something is an instance of a thing
(instance? java.lang.String "Hello")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(instance? String "Hello")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(let [pt (java.awt.Point. 1 2)]
  (set! (. pt -y) 5)
  (bean pt)) ;; just return `pt` if you want to use it
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:class</span>","value":":class"},{"type":"html","content":"<span class='clj-class'>java.awt.Point</span>","value":"java.awt.Point"}],"value":"[:class java.awt.Point]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:location</span>","value":":location"},{"type":"html","content":"<span class='clj-unkown'>#object[java.awt.Point 0x49cff29e &quot;java.awt.Point[x=1,y=5]&quot;]</span>","value":"#object[java.awt.Point 0x49cff29e \"java.awt.Point[x=1,y=5]\"]"}],"value":"[:location #object[java.awt.Point 0x49cff29e \"java.awt.Point[x=1,y=5]\"]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:x</span>","value":":x"},{"type":"html","content":"<span class='clj-double'>1.0</span>","value":"1.0"}],"value":"[:x 1.0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"html","content":"<span class='clj-double'>5.0</span>","value":"5.0"}],"value":"[:y 5.0]"}],"value":"{:class java.awt.Point, :location #object[java.awt.Point 0x13c39649 \"java.awt.Point[x=1,y=5]\"], :x 1.0, :y 5.0}"}
;; <=

;; @@
;; use memfn when you want ot trate a java method as a first-class function
(map (memfn charAt i) ["abc" "def" "ghi"] [0 1 2])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-char'>\\a</span>","value":"\\a"},{"type":"html","content":"<span class='clj-char'>\\e</span>","value":"\\e"},{"type":"html","content":"<span class='clj-char'>\\i</span>","value":"\\i"}],"value":"(\\a \\e \\i)"}
;; <=

;; @@
;; this is almost always more preferable though
(map #(.charAt %1 %2) ["abc" "def" "ghi"] [0 1 2])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-char'>\\a</span>","value":"\\a"},{"type":"html","content":"<span class='clj-char'>\\e</span>","value":"\\e"},{"type":"html","content":"<span class='clj-char'>\\i</span>","value":"\\i"}],"value":"(\\a \\e \\i)"}
;; <=

;; @@
;; bean returns a read-only implementation of the map abstraction base on its JavaBean props
(bean java.awt.Color/black)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:RGB</span>","value":":RGB"},{"type":"html","content":"<span class='clj-unkown'>-16777216</span>","value":"-16777216"}],"value":"[:RGB -16777216]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:alpha</span>","value":":alpha"},{"type":"html","content":"<span class='clj-unkown'>255</span>","value":"255"}],"value":"[:alpha 255]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:blue</span>","value":":blue"},{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}],"value":"[:blue 0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:class</span>","value":":class"},{"type":"html","content":"<span class='clj-class'>java.awt.Color</span>","value":"java.awt.Color"}],"value":"[:class java.awt.Color]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:colorSpace</span>","value":":colorSpace"},{"type":"html","content":"<span class='clj-unkown'>#object[java.awt.color.ICC_ColorSpace 0x31d58a2c &quot;java.awt.color.ICC_ColorSpace@31d58a2c&quot;]</span>","value":"#object[java.awt.color.ICC_ColorSpace 0x31d58a2c \"java.awt.color.ICC_ColorSpace@31d58a2c\"]"}],"value":"[:colorSpace #object[java.awt.color.ICC_ColorSpace 0x31d58a2c \"java.awt.color.ICC_ColorSpace@31d58a2c\"]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:green</span>","value":":green"},{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}],"value":"[:green 0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:red</span>","value":":red"},{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}],"value":"[:red 0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:transparency</span>","value":":transparency"},{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"}],"value":"[:transparency 1]"}],"value":"{:RGB -16777216, :alpha 255, :blue 0, :class java.awt.Color, :colorSpace #object[java.awt.color.ICC_ColorSpace 0x31d58a2c \"java.awt.color.ICC_ColorSpace@31d58a2c\"], :green 0, :red 0, :transparency 1}"}
;; <=

;; @@
;; proxy creates a proxy class to call the defined methods on that implements the named classes/interfaces given in the first array of the args
(let [p (proxy [java.io.InputStream] []
  (read
   ([] 1)
   ([^bytes bytes] 2)
   ([^bytes bytes off len] 3)))]
  (println (.read p))
  (println (.read p (byte-array 3)))
  (println (.read p (byte-array 3) 0 3)))
;; @@
;; ->
;;; 1
;;; 2
;;; 3
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; use typehints for speeeeeeeed
(defn len [x] (.length x))
(defn str-len [^String x] (.length x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;undisturbed-farm/str-len</span>","value":"#'undisturbed-farm/str-len"}
;; <=

;; @@
(time (reduce + (map len (repeat 1000000 "asdf"))))
;; @@
;; ->
;;; &quot;Elapsed time: 9049.1417 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>4000000</span>","value":"4000000"}
;; <=

;; @@
(time (reduce + (map str-len (repeat 1000000 "asdf"))))
;; bang
;; @@
;; ->
;;; &quot;Elapsed time: 393.5278 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>4000000</span>","value":"4000000"}
;; <=

;; @@
;; use warn-on-reflection to throw compiler errors where type hints aren't used
(set! *warn-on-reflection* true)
;; throws an error
(defn my-char-at [s] 
  (.charAt s 1))
;; doesn't
(defn my-th-char-at [^String s]
  (.charAt s 1))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;undisturbed-farm/my-th-char-at</span>","value":"#'undisturbed-farm/my-th-char-at"}
;; <=

;; @@
;; you can also use type hints for function returns
(defn foo ^String [] "hello")

(defn bar
  (^String [] "world")
  (^Integer [a] 1)
  (^java.util.List [a & args] '(1 2 3)))
(foo)
(bar)
(bar :a)
(bar :a :b)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"(1 2 3)"}
;; <=

;; @@
;; you can run really fast code using the functions from here under the "Support for Java Primitives" subheading
(defn asum [^floats xs]
  (areduce xs i ret (float 0)
    (+ ret (aget xs i))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;undisturbed-farm/asum</span>","value":"#'undisturbed-farm/asum"}
;; <=

;; @@
;; minor optimizations can drastically improve code
(defn foo [n]
  (loop [i 0]
    (if (< i n)
      (recur (inc i))
      i)))

(time (foo 100000))
;; typical runtime between 8 and 15 msecs
;; @@
;; ->
;;; &quot;Elapsed time: 11.3492 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>100000</span>","value":"100000"}
;; <=

;; @@
(defn foo2 [n]
  (let [n (int n)]
    (loop [i (int 0)]
      (if (< i n)
        (recur (inc i))
        i))))

(time (foo2 100000))
;; typical runtime between 3 and 5 msecs
;; @@
;; ->
;;; &quot;Elapsed time: 3.8217 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>100000</span>","value":"100000"}
;; <=

;; @@

;; @@
