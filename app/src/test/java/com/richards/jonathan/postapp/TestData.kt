package com.richards.jonathan.postapp

import com.richards.jonathan.postapp.data.entity.*
import retrofit2.Response

object TestData {

    fun getMockedUser(): Response<List<User>> {
        val userList: MutableList<User> = mutableListOf()

        val addressOne = Address("chancery Lane",
                "pes",
                "London",
                "ec1n 8ts",
                Geo("122.333", "1.8686"))

        val addressTwo = Address("Bond Street",
                "Denon",
                "London",
                "ec1n 8ts",
                Geo("122.333", "1.8686"))

        val companyOne = Company("Babylon", "Next Gen healthcare", "bs info")
        val companyTwo = Company("Amazon", "Buy everything here!!", "bs info")
        val companyThree = Company("jrichy photography", "Part time photographer", "bs info www.jonathanrichardsphotography.com")

        userList.add(User("1",
                "Luis Suarez",
                "user1",
                "l.suarez@gmail.com"
                , addressOne,
                "075566625",
                "www.barcleona.com", companyOne))
        userList.add(User("2",
                " Filip Luis",
                "user2",
                "luiz@gmail.com"
                , addressTwo,
                "0755434266625",
                "www.fdsfdsfsds.com", companyTwo))
        userList.add(User("3",
                "user3",
                "marky",
                "dsadsad@gmail.com"
                , addressOne,
                "075432423625",
                "www.mmndnd.com", companyThree))

        return Response.success(userList)
    }

    fun getMockedComments(): Response<List<Comment>> {
        val commentList = mutableListOf<Comment>()

        commentList.add(Comment("1",
                "1",
                "flghhhgip",
                "fdafds@fdsfsd.com",
                "Andy Murray is set to retire after Wimbledon in the summer but admitted the " +
                        "Australian Open could be his final tournament."))

        commentList.add(Comment("1",
                "2",
                "fdsfds",
                "ngfngd@fdsfsd.com",
                "Maurizio Sarri says Willian will not be allowed to leave" +
                        " Chelsea in January following reports Barcelona are ready to " +
                        "reignite their interest in the player."))

        commentList.add(Comment("1",
                "3",
                "hgfdhh",
                "gfdggghj@fdsfsd.com",
                "Monaco manager Thierry Henry has confirmed they are interested in" +
                        " signing Chelsea's Michy Batshuayi."))

        commentList.add(Comment("3",
                "4",
                "fthghglip",
                "fdahhfdfds@fdsfsd.com",
                "The Gunners are set to lose Ramsey to Juventus for nothing this summer after " +
                        "the Wales international agreed a deal with the Serie A champions after " +
                        "his contract was allowed to run down."))

        commentList.add(Comment("3",
                "5",
                "ngfjfj",
                "lojogfdg@fdsfsd.com",
                "Arsene Wenger sorted out his contract every year but seemed to forget everyone else's!"))

        commentList.add(Comment("2",
                "6",
                "ljknn",
                "nknngg@fdsfsd.com",
                "Mauricio Pochettino says Ole Gunnar Solskjaer will have no added motivation" +
                        " when Tottenham face Manchester United at Wembley on Sunday."))

        commentList.add(Comment("3",
                "7",
                "mnjnj",
                "fdafds@fcnklnklndsfsd.com",
                "Manchester United could be open to swapping Paul Pogba for Douglas Costa, " +
                        "plus more from the newspapers across Europe."))

        return Response.success(commentList)

    }

    fun getMockedPosts(): Response<List<Post>> {

        val postList = mutableListOf<Post>()

        postList.add(Post("1", "1", "football Topic One", "Our friends at Football" +
                " Whispers have trawled the Continental press to round up the latest transfer rumours from around Europe"))
        postList.add(Post("3", "2", "football Topic Two", "Cagliari midfielder" +
                " Nicolo Barella - who has been labelled 'the new Pirlo' - " +
                "has decided against joining Chelsea this month. Blues boss Maurizio Sarri "))
        postList.add(Post("2", "3", "football Topic Three", "Barcelona are " +
                "contemplating signing a striker during the January transfer window and" +
                " are interested in taking Chelsea striker Alvaro Morata on loan"))

        return Response.success(postList)

    }
}