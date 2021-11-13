(ns skyline.index-test
  (:require
   [clojure.test :as t]
   [skyline.index :as index]))

(def parse-input ["some-cat/some-pkg 1.0.0" "some-cat2/some-pkg2 2.0.0"])
(def parse-res (list
                (index/->Entry "some-pkg" "some-cat" "1.0.0")
                (index/->Entry "some-pkg2" "some-cat2" "2.0.0")))

(t/deftest parse-test
  (t/testing "Parse lines"
    (t/is (= (index/get-entries parse-input) parse-res))))
