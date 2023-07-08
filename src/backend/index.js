const functions = require("firebase-functions");
const admin = require("firebase-admin")
const NewsAPI = require("newsapi");
const newsapi = new NewsAPI("KEY_HERE");    // ADD valid key here
admin.initializeApp()
const db = admin.firestore()


exports.fetchData = functions.pubsub.schedule("55 23 * * *").timeZone("Asia/Kolkata").onRun((context)=>{
  const tags = ["sports",
    "politics",
    "entertainment",
    "technology",
    "business"];
  // feel free to add more
  for (let x=0; x<tags.length; x++) {
    newsapi.v2.topHeadlines({
      category: tags[x],
      country: "in",
      pageSize: 100,
    }).then((response)=>{
      if (response.status == "ok") {
        // add to db here 
        console.log("Fetched articles on Category ",tags[i]," number of articles : ",response.articles.length);
        // let batch = db.batch();
      } else {
        console.log("Some error", JSON.stringify(response));
      }
      return true;
    }).catch((error)=>{
      console.log("Error", error);
    });
  }  
})