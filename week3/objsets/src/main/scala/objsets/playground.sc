import scala.util.parsing.json._

object TweetData {
  val gizmodo = """[
{ "user": "gizmodo", "text": "Kindle Paperwhite Review: Forget Everything Else, This Is the E-Reader You Want http://t.co/737W6aNC", "retweets": 51.0 },
{ "user": "gizmodo", "text": "These new Apple patents give a sneak peek at what future iPhone cameras might have in store. http://t.co/0YT9rjxp", "retweets": 49.0 },
{ "user": "gizmodo", "text": "Ever wonder why the sky is dark at night? Here's your answer. http://t.co/eTKxkcaE", "retweets": 86.0 },
{ "user": "gizmodo", "text": "The weirdest thing people hate about the iPhone 5: http://t.co/GMwuRp8D", "retweets": 202.0 },
{ "user": "gizmodo", "text": "Data centers waste a completely absurd amount of energy. http://t.co/NcO9pXqb", "retweets": 58.0 }
]"""
  val amazondeals = """[
{ "user": "amazondeals", "text": "Deal of the Day: 50% Off Select BEARPAW Boots &amp; Slippers http://t.co/ZBvpSN33", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $38.69 - Honeywell Portable Wireless Door Chime and Push Button http://t.co/yYBV4ebr", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $124.99 - Ritmo Mundo Unisex White Sport Quartz Watch http://t.co/RfungjJC", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Deal of the Day: Starting from $3.99 Each: Essential MP3 Albums for Your Collection http://t.co/wotNjjir", "retweets": 5.0 }
]"""
  val mashable = """[
{ "user": "mashable", "text": "Which is sorriest, #Apple Maps or #Siri? @Charlie_White has the comic - http://t.co/YRXXJXGY", "retweets": 55.0 },
{ "user": "mashable", "text": "Watch These Quadrotor #Robots Learn to Play Catch [VIDEO] http://t.co/CHZ5BPfL", "retweets": 21.0 },
{ "user": "mashable", "text": "10 Funny @YouTube Clips of Sleeping Dogs http://t.co/ukPgWZjH", "retweets": 34.0 },
{ "user": "mashable", "text": "65 Digital Media Resources You May Have Missed http://t.co/u1LJWc22", "retweets": 64.0 },
{ "user": "mashable", "text": ".@HP Shows What @Windows 8 #Tablets for Business Will Look Like [PICS] http://t.co/Md6ua8Xc", "retweets": 32.0 }
]"""
}


class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
      "Text: " + text + " [" + retweets + "]"
}

def getTweets(tweeter: String) : Any = {
  val n = JSON.parseFull(tweeter) //.toList //convert from Option[Any] to List[Any]
  n.get
}

val x = getTweets(TweetData.amazondeals)

// "amazondeals", "Deal of the Day: 50% Off Select BEARPAW Boots &amp; Slippers http://t.co/ZBvpSN33", 0.0 ,  "amazondeals", "Lightning Deal! $38.69 - Honeywell Portable Wireless Door Chime and Push Button http://t.co/yYBV4ebr", 0.0
//val ww = (y(1).split(", ").strip)
//ww.foreach(x => println(x))
//val mm : Tuple3[String, String, Int] = new Tuple3[String, String, Int](y(1).split(", "))
//val(user, text, retweets)  = ww.asInstanceOf[Tuple3[String, String, Int]]
//val zz: Tweet = new Tweet(ww(0), ww(1), ww(2).stripSuffix(""" """).toInt)

//println(zz.user)
/*
val w = y(1).split(",")
val z: Tweet = new Tweet(w(0), w(1), w(2).toInt)
*/

//val z : List[Tweet] = TweetData.amazondeals.split(",\n").toList
