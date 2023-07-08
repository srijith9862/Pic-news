const functions = require("firebase-functions");
const admin = require("firebase-admin")
const NewsAPI = require("newsapi");
const newsapi = new NewsAPI("KEY_HERE");    // ADD valid key here
admin.initializeApp()
const db = admin.firestore()



exports.searchQuery = functions.https.onRequest((request,response)=>{
	/**
	 * REQUEST FORMAT 
	 * {
	 * 	query : String query 
	 * 	country : all for no filter, country code otherwise
	 * 	language : all for no filter, name of language otherwise
	 * 	category : all for no filter, category name otherwise
	 * 	date_upper : same
	 * 	date_lower : same
	 * }
	 */
	if(request.query == undefined || request.query == null || request.query.length == 0){
		response.send(JSON.stringify({status : "Error", message : "Invalid Query"}));
	}
	di = {}
	di["q"] = query
	if(!(request.country == "all")){
		di["country"] = request.country; // assuming country code will be valid
	}
	if(!(request.category == "all")){
		di["category"] = request.category;
	}
	if(!(request.language == "all")){
		di["language"] = request.language
	}
	if(!(request.date_upper == "all")){
		di["from"] = request.date_upper
	}
	if(!(request.date_lower == "all")){
		di["to"] = request.date_lower
	}
	di["sortBy"] = "relevancy";
	newsapi.v2.everything(di).then(resp =>{
		response.send(JSON.stringify(resp));
		return true;
	}).catch(err=>{
		response.send(JSON.stringify(err));
	})
	
})
