package meerkat.picnews

import meerkat.picnews.model.NewsArticle

class Config {
    companion object{
        var item : HashMap<String, NewsArticle> ?= null
        var position : Int = 0
    }
}