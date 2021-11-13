(ns skyline.index
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as string]))

;; TODO: Make this arbitrary
(def store-location (io/file "./ex/"))

(defn find-index [store])

(defn read-lines []
  (string/split-lines
   (slurp store-location)))

(defrecord Entry [name category version])

(defn parse-line
  "Turns `category/package 1.0.0` into
    { :name \"package\" :category \"category\" :version \"1.0.0\" }"
  [line]
  (let [[cat name version] (string/split line #"[\/\ ]")]
    (->Entry name cat version)))

(defn get-entries
  "Turns each line from index file into `entries`"
  [lines]
  (map parse-line lines))
