(ns hello-world.core
  (:require [clojure.browser.repl :as repl]
            [cljsjs.d3]
            [cljsjs.dimple]))

;(defonce conn
;  (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(.style (.selectAll js/d3 "p") "color" "red")
; d3.selectAll("p").style("color", "white");

(def dimple js/dimple)
(def svg (.newSvg dimple "body" 800 600))
(def data (clj->js [{"word" "Hello" "Awesomeness" 200}
                    {"word" "world" "Awesomeness" 300}]))
(def chart (js/dimple.chart. svg data))
(.addCategoryAxis chart "x" "word")
(.addMeasureAxis chart "y" "Awesomeness")
(.addSeries chart nil js/dimple.plot.bar)
(.draw chart)
;var svg = dimple.newSvg("body", 800, 600);
;var data = [
;            { "Word":"Hello", "Awesomeness":2000 },
;            { "Word":"World", "Awesomeness":3000 }
;            ];
;var chart = new dimple.chart(svg, data);
;chart.addCategoryAxis("x", "Word");
;chart.addMeasureAxis("y", "Awesomeness");
;chart.addSeries(null, dimple.plot.bar);
;chart.draw();