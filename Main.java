package org.example;

import org.example.AccessLevel;
import org.example.Member;
import org.example.MemberService;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static ArrayList<Movie> highestRatedMovies = new ArrayList<>(); // pakesh nakon, arrayliste khali vaseye top movies
    static Scanner scanner = new Scanner(System.in);
    static Member loginResult = null;
    static ArrayList<EditSuggestion> suggestionQue = new ArrayList<>();
    static ArrayList<Report> reports = new ArrayList<>();



    public static void main(String[] args) {

        MovieManage movieManage = MovieManage.getInstance(); // private access dre

/////////////////////////////////////////////////////////////////

        // sample members felan vase test kardan
        Member member1 = new Member("keinazj", "jafari", "j@gmail.com", "keinaz", "jafari", AccessLevel.MEMBER);
        Member member2 = new Member("keinpushj", "jafari", "k@gmail.com", "keinoush", "jafari", AccessLevel.MEMBER);
        Member member3 = new Member("anooshagh", "ghaffari", "a@gmail.com", "anoosha", "ghaffari", AccessLevel.MEMBER);
        MemberService.signup2(member1.getUsername(), member1.getPassword(), member1.getEmail(), member1.getName(), member1.getLastName(), member1.getAccessLevel());
        MemberService.signup2(member2.getUsername(), member2.getPassword(), member2.getEmail(), member2.getName(), member2.getLastName(), member2.getAccessLevel());
        MemberService.signup2(member3.getUsername(), member3.getPassword(), member3.getEmail(), member3.getName(), member3.getLastName(), member3.getAccessLevel());
        RoleInMovie roleInMovie1 = new RoleInMovie(MovieRole.ACTOR, member1);
        RoleInMovie roleInMovie2 = new RoleInMovie(MovieRole.DIRECTOR, member2);

        ArrayList<RoleInMovie> roleInMovieArrayList = new ArrayList<>();

        roleInMovieArrayList.add(roleInMovie1);
        roleInMovieArrayList.add(roleInMovie2);


// Define a range for the random date you want to generate
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay(); // Using some start date as min (inclusive)
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay(); // Using some end date as max (exclusive)

// Randomly choose a day between the range
        long randomDay = ThreadLocalRandom.current().nextInt(minDay, maxDay);

// Convert that random day back to a LocalDate object
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        Movie movie1 = new Movie("titanic", "drama", randomDate, "english", roleInMovieArrayList);
        Movie movie2 = new Movie("titanic2", "romance", randomDate, "french", roleInMovieArrayList);

        MovieManage.getInstance().AddMovie(movie1);
        MovieManage.getInstance().AddMovie(movie2);

        // sample database for forums
        Forum forum1 = new Forum("movie");
        Forum forum2 = new Forum("actors");
        ForumDB.getForums().add(forum1);
        ForumDB.getForums().add(forum2);

        Trivia trivia1 = new Trivia("whattttt");
        Trivia trivia2 = new Trivia("this is total bullshit");
        movie1.getTrivias().add(trivia1);
        movie2.getTrivias().add(trivia2);

        Goof goof1 = new Goof("this is a funny goof haha");
        movie1.getGoofs().add(goof1);

        Quote quote2 = new Quote("quotequote");
        movie2.getQuotes().add(quote2);

        Person person1 = new Person("hans", "zimmer");
        RoleInSong roleInSong1 = new RoleInSong(Role.WRITTENBY, person1);
        RoleInSong roleInSong2 = new RoleInSong(Role.PERFORMEDBY, person1);

        ArrayList<RoleInSong> rolesInSong = new ArrayList<>();
        ArrayList<SoundTrack> soundTracks = new ArrayList<>();
        rolesInSong.add(roleInSong1);
        rolesInSong.add(roleInSong2);

        SoundTrack soundTrack1 = new SoundTrack("my heart will go on", rolesInSong);
        soundTracks.add(soundTrack1);
        movie1.setSoundTracks(soundTracks);

        // random person
        Person Followperson = new Person("shiva", "zare");
        MemberService.getPeople().add(Followperson);

        //random admin
        Member admin1 = new Member("admin", "jafari", "j@gmail.com", "admin", "jafari", AccessLevel.MEMBER);
        admin1.setAccessLevel(AccessLevel.ADMIN);
        MemberService.getPeople().add(admin1);

        //random editor
        Member editor1 = new Member("editor", "jafari", "j@gmail.com", "admin", "jafari", AccessLevel.MEMBER);
        editor1.setAccessLevel(AccessLevel.EDITOR);
        MemberService.getPeople().add(editor1);

        GroupChat groupChat1 = new GroupChat("group1");
        GroupChat groupChat2 = new GroupChat("group2");
        GroupChatDB.getGroupChats().add(groupChat1);
        GroupChatDB.getGroupChats().add(groupChat2);
        Comment message1 = new Comment("hello new member",member1,null);
        Comment message2 = new Comment("hi",member3,null);
        groupChat1.getMessages().add(message1);
        groupChat2.getMessages().add(message2);
        groupChat2.getMessages().add(message1);

        /////////////////////////////////////////////////////////////////////////////


        // azinja shuru mishe code

        loginSignupPage();

    }

    public static void logout() {
        loginResult = null;
        loginSignupPage();

    }

    // methods

    public static void loginSignupPage() {
        while (loginResult == null) {

            System.out.println("1.signup \n2:Login\n3:watch");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "1":
                    System.out.println("Enter Username:");
                    String username = scanner.nextLine();

                    System.out.println("Enter Password:");
                    String password = scanner.nextLine();

                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();

                    System.out.println("Enter your name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter your LastName:");
                    String lastName = scanner.nextLine();


                    loginResult = MemberService.signup2(username, password, email, name, lastName, AccessLevel.MEMBER);
                    if (loginResult != null) {
                        System.out.println("Signup successful.");
                        homePage();
                    } else {
                        System.out.println("Signup failed - Email already in use.");
                    }
                    break;

                case "2":
                    System.out.println("Enter Username:");
                    String loginUsername = scanner.nextLine();

                    System.out.println("Enter Password:");
                    String loginPassword = scanner.nextLine();


                    loginResult = MemberService.login(loginUsername, loginPassword);
                    if (loginResult != null) {
                        System.out.println("Login successful.");
                        homePage();
                        // taraf login kard, typesho mikhaim bedoonim ke safhe makhsoosesh biad
                    } else {
                        System.out.println("Login failed - Incorrect username or password");
                    }
                    break;

                case "3":{
                    System.out.println("select what you want\n1:see the list of all movies\n2:see the chart of top-rated movies\n3.exit");
                    String answer = scanner.nextLine();
                    int count =1;
                    switch (answer){
                        case "1":{
                            for(Movie movies: MovieManage.getInstance().getMovies()){
                                System.out.println(count+"####");
                                movies.showMovieInfo(movies);
                                count++;
                            }

                        }
                        case"2":{
                            if(MovieManage.getInstance().getMovies()==null){
                                System.out.println("nothing to show");
                            }
                            else{// see the chart of top rated movies which are movies rated 5 and 4 stars
                                for (Movie movie : MovieManage.getInstance().getMovies()) {
                                    for (Rating rate : movie.getRatings()) {
                                        if (rate.getRate().equals(Rate.FIVE) || rate.getRate().equals(Rate.FOUR)) {
                                            highestRatedMovies.add(movie);
                                        }
                                    }
                                }
                                for (Movie topRatedMovie : highestRatedMovies) {
                                    System.out.println(topRatedMovie.getTitle());
                                }
                                break;
                            }
                        }
                        break;
                        case "3":{
                            System.exit(0);
                        }
                    }


                }
            }

        }
    }

    public static void homePage() { // baad az login shodan
        AccessLevel access = loginResult.getAccessLevel();
        if (access.equals(AccessLevel.MEMBER)) { // faghat kararye member
            System.out.println("welcome member!");
            memberActions();

        } else if (access.equals(AccessLevel.ADMIN)) {
            System.out.println("enter in:\n1.admin mode\n2:member mode");
            String mode = scanner.nextLine();
            if (mode.equalsIgnoreCase("1")) {
                System.out.println("welcome admin!");
                adminActions();
            } else if (mode.equalsIgnoreCase("2")) {
                System.out.println("welcome member!");
                memberActions();
            }
        } else if (access.equals(AccessLevel.EDITOR)) {
            System.out.println("enter in\n1.editor mode\n2.member mode");
            String mode = scanner.nextLine();
            if (mode.equalsIgnoreCase("1")) {
                System.out.println("welcome editor");
                editorActions();
            } else if (mode.equalsIgnoreCase("2")) {
                System.out.println("welcome member");
                memberActions();
            }
        }
    }


    public static void memberActions() {

        while (true) {
            System.out.println("select what you want\n1:see the list of all movies\n2:search a movie\n3:see the chart of top-rated movies\n4:enter the forum page\n5:see the list of your watchlists\n6:see the list of your favorites");
            System.out.println("7:search a person\n8:see your suggested movies\n9:advanced search\n10:enter a group chat\n11.see the groups you have joined before\n0:logout\n-1:exit");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    MovieManage movieManager = MovieManage.getInstance();
                    ArrayList<Movie> allMovies = movieManager.getMovies();
                    if(allMovies==null){
                        System.out.println("movie list is empty");
                    }
                    else{
                    for (Movie movie : allMovies) {
                        System.out.println(movie.getTitle());
                    }}
                    break;

                case "2": // movie select kon, boro karaye movie anjam bede
                    MovieSelectedActions();
                    break;

                case "3": {
                    if(MovieManage.getInstance().getMovies()==null){
                        System.out.println("nothing to show");
                    }
                    else{// see the chart of top rated movies which are movies rated 5 and 4 stars
                    for (Movie movie : MovieManage.getInstance().getMovies()) {
                        for (Rating rate : movie.getRatings()) {
                            if (rate.getRate().equals(Rate.FIVE) || rate.getRate().equals(Rate.FOUR)) {
                                highestRatedMovies.add(movie);
                            }
                        }
                    }
                    for (Movie topRatedMovie : highestRatedMovies) {
                        System.out.println(topRatedMovie.getTitle());
                    }
                    break;
                }}


                case "4": {

                    // enter a specific topic
                    ArrayList<Forum> forumTopics = ForumDB.getForums();
                    int counter = 1;
                    for (Forum forum : forumTopics) {
                        System.out.println(String.valueOf(counter) + ". " + forum.getTopic());
                        counter++;
                    }
                    System.out.println("choose the number of the topic you want to enter");
                    int num = Integer.parseInt(scanner.nextLine());
                    Forum resultForum = forumTopics.get(num - 1);
                    //System.out.println(resultForum.getTopic());

                    while (true) {

                        System.out.println("select what to do in this forum");

                        System.out.println("1.write a new comment\n2.see all existing comments\n3.go to the previous page");
                        String answer4 = scanner.nextLine();

                        // see all existing comments
                        if (answer4.equalsIgnoreCase("2")) {
                            ArrayList<Comment> forumComments = resultForum.getComments();
                            int counter2 = 1;
                            for (Comment comment : forumComments) {
                                System.out.println(String.valueOf(counter2) + ". " + comment.getText());
                                counter2++;
                            }
                        }


                        // add a new comment
                        else if (answer4.equalsIgnoreCase("1")) {
                            ArrayList<Comment> forumComments = resultForum.getComments();
                            int counter3 = 1;

                            System.out.println("reply to: enter the number of the comment (if it is not a reply, press enter in the next line)");

                            String replyTo = scanner.nextLine(); // indexe un commento migire ke mikhad reply bzne

                            if (replyTo.equals("")) {
                                // reply be chizi nist
                                System.out.println("enter you comment:");
                                String text = scanner.nextLine();
                                Comment newComment = new Comment(text, loginResult, null);
                                resultForum.getComments().add(newComment);
                            } else {
                                int replyTo2 = Integer.parseInt(replyTo);
                                System.out.println("enter you comment:");
                                String text = scanner.nextLine();
                                Comment resultComment = forumComments.get(replyTo2 - 1); // mige reply be chie
                                Comment newComment = new Comment(text, loginResult, resultComment);
                                resultForum.getComments().add(newComment);
                            }
                        }
                        else if(answer4.equalsIgnoreCase("3")){
                            memberActions();
                        }
                    }
                }
                case "5": { // see all movies in watchlist
                    ArrayList<Movie> watchlistMovies = loginResult.getWatchlist();
                    for (Movie movieInWatchlist : watchlistMovies) {
                        System.out.println(movieInWatchlist.getTitle());
                    }
                    break;

                }
                case "6": {
                    ArrayList<Movie> favoriteMovies = loginResult.getFavorites();
                    for (Movie favoriteMovie : favoriteMovies) {
                        System.out.println(favoriteMovie.getTitle());
                    }
                    break;
                }

                case "7": { // person search kone age khast follow kone ya informationasho bebine
                    System.out.println("enter the name of the person you want to see");
                    String searchedPersonName = scanner.nextLine();
                    System.out.println("enter the last name of the person you want to see");
                    String searchPersonLastName = scanner.nextLine();
                    Person searchPerson = new Person(searchedPersonName, searchPersonLastName);
                    Person searchResult = null;
                    for (Person person : MemberService.getPeople()) {
                        if (person.getName().equalsIgnoreCase(searchPerson.getName()) && person.getLastName().equalsIgnoreCase(searchPerson.getLastName())) { // person found , vali uuid check nashode va equals javab nadad
                            searchResult = person;
                            System.out.println("1.follow\n2.unfollow\n3.see all followers\n4.see all followings ");
                            String followUnfollow = scanner.nextLine();
                            // follow
                            if (followUnfollow.equalsIgnoreCase("1")) {
                                searchResult.getFollowers().add(loginResult); // followere n person shodam
                                loginResult.getFollowings().add(searchResult);
                                System.out.println("followed successfully");

                            } else if (followUnfollow.equalsIgnoreCase("2")) {
                                searchResult.getFollowers().remove(loginResult);
                                loginResult.getFollowings().remove(searchResult);
                                System.out.println("unfollowed successfully");

                            } else if (followUnfollow.equalsIgnoreCase("3")) {// liste followers bebine
                                for (Person follower : searchResult.getFollowers()) {
                                    System.out.println(follower.getName() + " " + follower.getLastName());
                                }
                            } else if (followUnfollow.equalsIgnoreCase("4")) { // liste following mibine
                                for (Member following : searchResult.getFollowers()) {
                                    System.out.println(following.getName() + " " + following.getLastName());
                                }
                            } else {
                                System.out.println("something wrong");
                                break;


                            }


                        }
                    }
                    break;
                }


                case "0": {
                    logout();
                    break;
                }
                case "-1": {
                    System.exit(0);
                    break;
                }

                case "8": {
                    for (Movie suggestion : loginResult.createSuggestions(loginResult)) {
                        System.out.println(suggestion.getTitle());

                    }
                    break;
                }

                case "9":{ // advanced search
                    System.out.println("1.filter by genre\n2.filter by people\n3.filter by language\n4.filter by rate");
                    String answer1 = scanner.nextLine();
                    if(answer1.equalsIgnoreCase("1")){
                        System.out.println("enter the genre");
                        String genre = scanner.nextLine();
                        for(Movie movie: MovieManage.getInstance().getMovies()){
                            if(movie.getGenre().equalsIgnoreCase(genre)){
                                System.out.println(movie.getTitle());
                            }
                        }
                    }
                    else if(answer1.equalsIgnoreCase("2")){
                        System.out.println("enter the name:");
                        String name = scanner.nextLine();
                        System.out.println("enter the last name");
                        String lastName = scanner.nextLine();
                        Person searchedPerson =new Person(name,lastName);
                        for(Person person: MemberService.getPeople()){
                            if(searchedPerson.getName().equalsIgnoreCase(person.getName()) && searchedPerson.getLastName().equalsIgnoreCase(person.getLastName())){
                                System.out.println("person found, you can see this person's movies below");
                                for(Movie movie: MovieManage.getInstance().getMovies()){
                                    ArrayList<RoleInMovie> roleInMovieArrayList = movie.getRolesInMovie();
                                    for(RoleInMovie roleInMovie:roleInMovieArrayList){
                                        if(roleInMovie.getPerson().getName().equalsIgnoreCase(person.getName())&&roleInMovie.getPerson().getLastName().equalsIgnoreCase(person.getLastName())){
                                            System.out.println(movie.getTitle());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(answer1.equalsIgnoreCase("3")){ // filter by language
                        System.out.println("enter the language");
                        String language = scanner.nextLine();
                        for(Movie movies: MovieManage.getInstance().getMovies()){
                            if(movies.getLanguage().equalsIgnoreCase(language)){
                                System.out.println(movies.getTitle());
                            }
                        }
                    }

                    if(answer1.equalsIgnoreCase("4")){ // search bar asase rate
                        System.out.println("enter the minimum rate for the rating number(between 1 to 5)");
                        int low = Integer.parseInt(scanner.nextLine());
                        System.out.println("enter the maximum rate for the rating number(between 1 to 5)");
                        int high = Integer.parseInt(scanner.nextLine());

                        for (Movie movies: MovieManage.getInstance().getMovies()){
                            for(Rating rating : movies.getRatings()){
                              if(rating.convertToNumber(rating)>=low && rating.convertToNumber(rating)<=high){
                                  System.out.println(movies.getTitle());
                              }
                            }
                        }
                    }
                    break;
                }
                case "10":{ // group chat
                    ArrayList<GroupChat> groupChatNames=GroupChatDB.getGroupChats();
                    System.out.println("1.join a group\n2.create a group");
                    String action = scanner.nextLine();
                    if(action.equals("1")) {

                        System.out.println("choose which group you want to join");

                        int counter = 1;
                        for (GroupChat groupChat : groupChatNames) {
                            System.out.println(String.valueOf(counter) + ". " + groupChat.getName());
                            counter++;
                        }

                        int num = Integer.parseInt(scanner.nextLine());
                        GroupChat groupResult = groupChatNames.get(num - 1);
                        if (groupResult.getMembers().contains(loginResult)) {
                            System.out.println("you already joined this group ");
                        } else {
                            groupResult.getMembers().add(loginResult);
                            System.out.println("you joined the group!");

                            while (true) {

                                System.out.println("select what to do in the group");

                                System.out.println("1.send a new message\n2.see all messages\n3.leave the group\n4.go back to the previous page\n5.see all members");
                                String answ = scanner.nextLine();

                                if (answ.equalsIgnoreCase("2")) {
                                    ArrayList<Comment> groupMessages = groupResult.getMessages();
                                    int counter2 = 1;
                                    for (Comment message : groupMessages) {
                                        System.out.println(String.valueOf(counter2) + "." + message.getText());
                                        counter2++;
                                    }

                                } else if (answ.equalsIgnoreCase("3")) {
                                    groupResult.getMembers().remove(loginResult);
                                    System.out.println("you left the group");
                                    memberActions();
                                } else if (answ.equalsIgnoreCase("1")) {
                                    ArrayList<Comment> groupMessages = groupResult.getMessages();
                                    int counter3 = 1;

                                    System.out.println("reply to: enter the number of the message(if it is not a reply, press enter in the next line)");
                                    String replyTo = scanner.nextLine();

                                    if (replyTo.equals("")) {
                                        System.out.println("enter you message");
                                        String text = scanner.nextLine();
                                        Comment newMessage = new Comment(text, loginResult, null);
                                        groupResult.getMessages().add(newMessage);
                                    } else {
                                        int replyto2 = Integer.parseInt(replyTo);
                                        System.out.println("enter you message");
                                        String text = scanner.nextLine();
                                        Comment resultMessage = groupMessages.get(replyto2 - 1);
                                        Comment newMessage = new Comment(text, loginResult, resultMessage);
                                        groupResult.getMessages().add(newMessage);
                                    }
                                } else if (answ.equalsIgnoreCase("4")) {
                                    memberActions();
                                }
                                else if(answ.equalsIgnoreCase("5")){
                                    int c = 1;
                                    for(Member member: groupResult.getMembers()){
                                        System.out.println(c+"."+member.getName()+" "+member.getLastName());
                                    }
                                }
                                else {
                                    System.out.println("unknown action for the group");
                                }
                            }

                        }
                    }

                    else if(action.equals("2")){
                        System.out.println("enter the name of your group");
                        String gpName = scanner.nextLine();
                        GroupChat createdGp = new GroupChat(gpName);
                        createdGp.getMembers().add(loginResult);
                        GroupChatDB.getGroupChats().add(createdGp);
                        System.out.println("group created!");

                        while (true) {

                            System.out.println("select what to do in the group");

                            System.out.println("1.send a new message\n2.see all messages\n3.delete the group\n4.go back to the previous page\n5.see all members\n6.add a new member");
                            String answ = scanner.nextLine();

                            if (answ.equalsIgnoreCase("2")) {
                                ArrayList<Comment> groupMessages = createdGp.getMessages();
                                int counter2 = 1;
                                for (Comment message : groupMessages) {
                                    System.out.println(String.valueOf(counter2) + "." + message.getText());
                                    counter2++;
                                }

                            } else if (answ.equalsIgnoreCase("3")) {
                                GroupChatDB.getGroupChats().remove(createdGp);
                                System.out.println("you deleted the group");
                                memberActions();
                            } else if (answ.equalsIgnoreCase("1")) {
                                ArrayList<Comment> groupMessages = createdGp.getMessages();
                                int counter3 = 1;

                                System.out.println("reply to: enter the number of the message(if it is not a reply, press enter in the next line)");
                                String replyTo = scanner.nextLine();

                                if (replyTo.equals("")) {
                                    System.out.println("enter you message");
                                    String text = scanner.nextLine();
                                    Comment newMessage = new Comment(text, loginResult, null);
                                    createdGp.getMessages().add(newMessage);
                                } else {
                                    int replyto2 = Integer.parseInt(replyTo);
                                    System.out.println("enter you message");
                                    String text = scanner.nextLine();
                                    Comment resultMessage = groupMessages.get(replyto2 - 1);
                                    Comment newMessage = new Comment(text, loginResult, resultMessage);
                                    createdGp.getMessages().add(newMessage);
                                }
                            } else if (answ.equalsIgnoreCase("4")) {
                                memberActions();
                            }

                            else if(answ.equalsIgnoreCase("5")){
                                int c = 1;
                                for(Member member: createdGp.getMembers()){
                                    System.out.println(c+"."+member.getName()+" "+member.getLastName());
                                }
                            }
                            else if(answ.equalsIgnoreCase("6")){
                                System.out.println("enter the name of the person you want to add:");
                                String name = scanner.nextLine();
                                System.out.println("enter the last name of the person you want to add:");
                                String lastName =scanner.nextLine();
                                int found = 0;
                                for (Person person : MemberService.getPeople()) {
                                    if (person.getName().equalsIgnoreCase(name) && person.getLastName().equalsIgnoreCase(lastName)) {
                                        // Check if the person is an instance of Member before casting
                                        if (person instanceof Member) {
                                            Member member = (Member) person;
                                            createdGp.getMembers().add(member);
                                            found = 1;
                                        } else {
                                            System.out.println("The person is not a member.");
                                        }
                                    }
                                }

                                if(found==0){
                                    System.out.println("member not found");
                                }
                            }

                            else {
                                System.out.println("unknown action for the group");
                            }
                        }

                    }

                    break;
                }

                case "11":{
                    ArrayList<GroupChat> groupChats = GroupChatDB.getGroupChats();
                    for(GroupChat groupChat: groupChats){
                        for(Member member: groupChat.getMembers()){
                            if(member.equals(loginResult)){
                                loginResult.getGroupChats().add(groupChat);
                            }
                        }
                    }
                    int size = loginResult.getGroupChats().size();

                    if(size==0){
                        System.out.println("you have no groups");
                        break;
                    }
                    else{
                        System.out.println("which one you want to enter?enter the number");
                        int counter = 1;
                        for (GroupChat groupChat: loginResult.getGroupChats()){
                            System.out.println(counter+"."+groupChat.getName());
                            counter++;
                        }
                        int enter = Integer.parseInt(scanner.nextLine());
                        GroupChat resultGp = loginResult.getGroupChats().get(enter-1);

                        while (true) {

                            System.out.println("select what to do in the group");

                            System.out.println("1.send a new message\n2.see all messages\n3.leave the group\n4.go back to the previous page\n5.see all members");
                            String answ = scanner.nextLine();

                            if (answ.equalsIgnoreCase("2")) {
                                ArrayList<Comment> groupMessages = resultGp.getMessages();
                                int counter2 = 1;
                                for (Comment message : groupMessages) {
                                    System.out.println(String.valueOf(counter2) + "." + message.getText());
                                    counter2++;
                                }

                            } else if (answ.equalsIgnoreCase("3")) {
                                resultGp.getMembers().remove(loginResult);
                                System.out.println("you left the group");
                                memberActions();
                            } else if (answ.equalsIgnoreCase("1")) {
                                ArrayList<Comment> groupMessages = resultGp.getMessages();
                                int counter3 = 1;

                                System.out.println("reply to: enter the number of the message(if it is not a reply, press enter in the next line)");
                                String replyTo = scanner.nextLine();

                                if (replyTo.equals("")) {
                                    System.out.println("enter you message");
                                    String text = scanner.nextLine();
                                    Comment newMessage = new Comment(text, loginResult, null);
                                    resultGp.getMessages().add(newMessage);
                                } else {
                                    int replyto2 = Integer.parseInt(replyTo);
                                    System.out.println("enter you message");
                                    String text = scanner.nextLine();
                                    Comment resultMessage = groupMessages.get(replyto2 - 1);
                                    Comment newMessage = new Comment(text, loginResult, resultMessage);
                                    resultGp.getMessages().add(newMessage);
                                }
                            } else if (answ.equalsIgnoreCase("4")) {
                                memberActions();
                            }
                            else if(answ.equalsIgnoreCase("5")){
                                int c = 1;
                                for(Member member: resultGp.getMembers()){
                                    System.out.println(c+"."+member.getName()+" "+member.getLastName());
                                }
                            }
                            else {
                                System.out.println("unknown action for the group");
                            }
                        }

                    }
                }

                default:
                    System.out.println("Unknown action.");
                    break;

            }
        }
    }

    public static void MovieSelectedActions() {

        System.out.println("enter the name of the movie you are looking for:");
        String title = scanner.nextLine();
        Movie searchedMovie = MovieManage.getInstance().findMovieByTitle(title);

        while (true) {

            //System.out.println(searchedMovie.getGenre());
            System.out.println("what do you want to do with this movie?\n1:write a review for\n2:Rate this movie\n3:visit the trivia section\n4:visit the goof section\n5:visit the quote section");
            System.out.println("6:visit the soundtrack section\n7:add this movie to watchlists\n8:add this movie to favorites\n9:go back to homePage\n10:see information\n11:report this movie\n0:logout\n-1:exit");

            String ans = scanner.nextLine();
            switch (ans) {
                case "1": { // review bede
                    ArrayList<Review> reviews = searchedMovie.getReviews();
                    boolean notAlreadyReviewed = true;
                    for (Review review : reviews) {
                        if (review.getRator().equals(loginResult)) {
                            System.out.println("you have already written a review for this movie!");
                            notAlreadyReviewed = false;
                            break;
                        }
                    }

                    if (notAlreadyReviewed) {

                        boolean spoiler = false;
                        System.out.println("enter the text of the review:");
                        String text = scanner.nextLine();
                        System.out.println("does the review contain a spoiler?:type 'yes' or 'no' ");
                        String spoilerOrNo = scanner.nextLine();
                        if (spoilerOrNo.equalsIgnoreCase("yes")) {
                            spoiler = true;
                        } else if (spoilerOrNo.equalsIgnoreCase("no")) {
                            spoiler = false;
                        } else {
                            System.out.println("invalid input");
                        }
                        System.out.println("enter a rate number from 1 to 5");
                        String Number = scanner.nextLine();
                        Rate rateNumber = Rate.ZERO;
                        if (Number.equalsIgnoreCase("1")) {
                            rateNumber = Rate.ONE;
                        } else if (Number.equalsIgnoreCase("2")) {
                            rateNumber = Rate.TWO;
                        } else if (Number.equalsIgnoreCase("3")) {
                            rateNumber = Rate.THREE;
                        } else if (Number.equalsIgnoreCase("4")) {
                            rateNumber = Rate.FOUR;
                        } else if (Number.equalsIgnoreCase("5")) {
                            rateNumber = Rate.FIVE;
                        }

                        Member rator = loginResult;
                        Movie rateShode = searchedMovie;


                        Review review = new Review(text, spoiler, rateNumber, rator, rateShode);
                        Rating rating = new Rating(rateNumber, rator, rateShode);
                        searchedMovie.getReviews().add(review);
                        searchedMovie.getRatings().add(rating);

                        break;
                    }

                    break;
                }


                case "2": { // rate bede
                    Member rateDahande = loginResult;
                    Movie rateShodeMovie = searchedMovie;

                    boolean notAlreadyRated = true;
                    ArrayList<Rating> ratings = searchedMovie.getRatings();
                    for (Rating rating : ratings) {
                        if (rating.getRator().equals(loginResult)) {
                            System.out.println("you have already written a review for this movie!");
                            notAlreadyRated = false;
                            break;
                        }
                    }
                    if (notAlreadyRated) {


                        System.out.println("enter a rate number from 1 to 5");
                        String Number = scanner.nextLine();
                        Rate rateNumber = Rate.ZERO;
                        if (Number.equalsIgnoreCase("1")) {
                            rateNumber = Rate.ONE;
                        } else if (Number.equalsIgnoreCase("2")) {
                            rateNumber = Rate.TWO;
                        } else if (Number.equalsIgnoreCase("3")) {
                            rateNumber = Rate.THREE;
                        } else if (Number.equalsIgnoreCase("4")) {
                            rateNumber = Rate.FOUR;
                        } else if (Number.equalsIgnoreCase("5")) {
                            rateNumber = Rate.FIVE;
                        }

                        Rating rating = new Rating(rateNumber, loginResult, searchedMovie);
                        searchedMovie.getRatings().add(rating);
                        break;
                    }
                    break;
                }

                case "3": { // trivia haro bekhoone ya add kone beheshun, counter gozashtam nmdnm chera
                    System.out.println("1.view all trivias\n2.add a trivia");
                    String answer3 = scanner.nextLine();
                    ArrayList<Trivia> allTrivias = searchedMovie.getTrivias();

                    if (answer3.equalsIgnoreCase("1")) { // see all trivias of the movie
                        int counter = 1;
                        for (Trivia trivia : allTrivias) {
                            System.out.println(String.valueOf(counter) + ". " + trivia.getText());
                            counter++;
                        }
                    } else if (answer3.equalsIgnoreCase("2")) {
                        System.out.println("enter the trivia text:");
                        String triviaText = scanner.nextLine();
                        Trivia newTrivia = new Trivia(triviaText);
                        newTrivia.setWriter(loginResult);
                        searchedMovie.getTrivias().add(newTrivia);
                    }
                    break;
                }


                case "4": {
                    System.out.println("1.see all goofs\n2:add a goof");
                    String answer4 = scanner.nextLine();
                    ArrayList<Goof> allGoofs = searchedMovie.getGoofs();

                    //print all goofs
                    if (answer4.equalsIgnoreCase("1")) {
                        int counter = 1;
                        for (Goof goof : allGoofs) {
                            System.out.println(String.valueOf(counter) + ". " + goof.getText());
                            counter++;
                        }
                    }
                    // add a goof
                    else if (answer4.equalsIgnoreCase("2")) {
                        System.out.println("enter the goof's text");
                        String goofText = scanner.nextLine();
                        Goof newGoof = new Goof(goofText);
                        newGoof.setWriter(loginResult);
                        searchedMovie.getGoofs().add(newGoof);
                    }
                    break;
                }


                // quote section like trivia and goof part
                case "5": {
                    ArrayList<Quote> allQuotes = searchedMovie.getQuotes();
                    System.out.println("1.see all quotes\n2.add a quote");
                    String answer5 = scanner.nextLine();

                    // see all quotes
                    if (answer5.equalsIgnoreCase("1")) {
                        int counter = 1;
                        for (Quote quote : allQuotes) {
                            System.out.println(String.valueOf(counter) + ". " + quote.getText());
                            counter++;
                        }
                    }
                    // write a new quote
                    else if (answer5.equalsIgnoreCase("2")) {
                        System.out.println("enter the quote text");
                        String QuoteText = scanner.nextLine();
                        Quote newQuote = new Quote(QuoteText);
                        newQuote.setWriter(loginResult);
                        searchedMovie.getQuotes().add(newQuote);

                    }

                    break;
                }


                case "6": { //  add or view soundtracks
                    ArrayList<SoundTrack> soundTrackha = searchedMovie.getSoundTracks();


                    System.out.println("1.see all soundtracks\n2.add a soundtrack");
                    String answer6 = scanner.nextLine();
                    if (answer6.equalsIgnoreCase("1")) {
                        int counter = 1;
                        for (SoundTrack soundTrack : soundTrackha) {
                            ArrayList<RoleInSong> roleInSong3 = soundTrack.getRolesInSong();
                            Person songwriter = null;
                            Person singer = null;
                            for (RoleInSong r : roleInSong3) {
                                if (r.getRole() == Role.WRITTENBY) {
                                    songwriter = r.getPerson();
                                }
                                if (r.getRole() == Role.PERFORMEDBY) {
                                    singer = r.getPerson();
                                }

                            }
                            System.out.println(String.valueOf(counter) + ". " + "song Name: " + soundTrack.getName());
                            if (songwriter != null) {
                                System.out.println("Written by: " + songwriter.getName() + " " + songwriter.getLastName());
                            }
                            if (singer != null) {
                                System.out.println("Performed by: " + singer.getName() + " " + singer.getLastName());
                            } else {
                                System.out.println("more information not available");
                            }

                            // baraye roles in song print shodane chikar konam?

                            counter++;
                        }
                    } else if (answer6.equalsIgnoreCase("2")) {

                        System.out.println("enter the name of the song:");
                        String songName = scanner.nextLine();

                        System.out.println("enter the name of the songwriter if available:");
                        String name2 = scanner.nextLine();
                        System.out.println("enter the last name of the songwriter if available:");
                        String lastName2 = scanner.nextLine();

                        System.out.println("enter the name of the singer if available:");
                        String name3 = scanner.nextLine();
                        System.out.println("enter the last name of the singer if available:");
                        String lastName3 = scanner.nextLine();

                        Person songwriter = new Person(name2, lastName2);
                        Person singer = new Person(name3, lastName3);

                        RoleInSong newSongwriter = new RoleInSong(Role.WRITTENBY, songwriter);
                        RoleInSong newSinger = new RoleInSong(Role.PERFORMEDBY, singer);
                        ArrayList<RoleInSong> roleInSongs100 = new ArrayList<>();
                        roleInSongs100.add(newSinger);
                        roleInSongs100.add(newSongwriter);

                        SoundTrack newSoundTrack = new SoundTrack(songName, roleInSongs100);
                        soundTrackha.add(newSoundTrack);
                    }
                    break;
                }


                case "7": { // add krdn be watchlist
                    ArrayList<Movie> watchlist = loginResult.getWatchlist();
                    watchlist.add(searchedMovie);
                    break;
                }

                case "8": {// add krdn be favorites
                    ArrayList<Movie> favorites = loginResult.getFavorites();
                    favorites.add(searchedMovie);
                    break;
                }


                case "9": {
                    homePage();
                    break;
                }

                case "0": {
                    logout();
                    break;
                }
                case "-1": {
                    System.exit(0);
                }

                case "10": {
                    searchedMovie.showMovieInfo(searchedMovie);
                    break;
                }

                case "11":{
                    System.out.println("enter the report text");
                    String text = scanner.nextLine();
                    String topic = searchedMovie.getTitle();
                    Report newReport = new Report(text,topic);
                    searchedMovie.getReports().add(newReport);
                    reports.add(newReport);
                    System.out.println("added to the reports successfully. wait for the admin to process it");
                    break;
                }

                default:
                    System.out.println("Unknown action.");
                    break;
            }

        }
    }


    public static void adminActions() {
        while (true) {
            System.out.println("select what you want\n1.add a movie to all movies\n2.search a movie to edit\n3.remove a person\n4.add a person\n5.view edit suggestions\n6.view all reports\n0:logout\n-1:exit");
            String answer1 = scanner.nextLine();

            switch (answer1) {

                case "1": {
                    System.out.println("enter the title of the movie");
                    String movieTitle = scanner.nextLine();
                    System.out.println("what is the genre?");
                    String movieGenre = scanner.nextLine();
                    System.out.println("enter its language");
                    String movieLanguage = scanner.nextLine();
                    System.out.print("Enter its release date(dd/mm/yyyy): ");
                    String dateStr = scanner.nextLine(); // tarikh be formate date begire
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(dateStr, formatter);

                    ArrayList<RoleInMovie> CombinedRoleInMove = new ArrayList<>();
                    System.out.println("how many actors you want to enter to add to this movie?");
                    // baraye arrayliste roleinmovie
                    int tedad = Integer.parseInt(scanner.nextLine());
                    int counter = 0;
                    while (counter < tedad) {
                        System.out.println("name of the actor:");
                        String actorName = scanner.nextLine();
                        System.out.println("last name of the actor");
                        String actorLastName = scanner.nextLine();
                        Person newActor = new Person(actorName, actorLastName); // actor sakhte shod
                        MemberService.getPeople().add(newActor);
                        RoleInMovie newActorInMovie = new RoleInMovie(MovieRole.ACTOR, newActor);
                        CombinedRoleInMove.add(newActorInMovie);
                        counter++;
                    }

                    System.out.println("how many writers you want to enter to add to this movie?");
                    // baraye arrayliste roleinmovie
                    int tedad2 = Integer.parseInt(scanner.nextLine());
                    int counter2 = 0;
                    while (counter2 < tedad2) {
                        System.out.println("name of the writer:");
                        String writerName = scanner.nextLine();
                        System.out.println("last name of the writer");
                        String writerLastName = scanner.nextLine();
                        Person newWriter = new Person(writerName, writerLastName); // writer sakhte shod
                        MemberService.getPeople().add(newWriter);
                        RoleInMovie newWriterInMovie = new RoleInMovie(MovieRole.WRITER, newWriter);
                        CombinedRoleInMove.add(newWriterInMovie);
                        counter2++;
                    }


                    System.out.println("how many directors you want to enter to add to this movie?");
                    // baraye arrayliste roleinmovie
                    int tedad3 = Integer.parseInt(scanner.nextLine());
                    int counter3 = 0;
                    while (counter3 < tedad3) {
                        System.out.println("name of the director:");
                        String directorName = scanner.nextLine();
                        System.out.println("last name of the director");
                        String directprLastName = scanner.nextLine();
                        Person newDirector = new Person(directorName, directprLastName); // actor sakhte shod
                        MemberService.getPeople().add(newDirector);
                        RoleInMovie newDirectorInMovie = new RoleInMovie(MovieRole.DIRECTOR, newDirector);
                        CombinedRoleInMove.add(newDirectorInMovie);
                        counter3++;
                    }

                    Movie newMovie = new Movie(movieTitle, movieGenre, date, movieLanguage, CombinedRoleInMove);
                    MovieManage.getInstance().AddMovie(newMovie);
                    break;
                }

                case "2": {

                    System.out.println("enter the title of the movie");
                    Movie searchedMovie = null;
                    String movietitle = scanner.nextLine();
                    for (Movie movie : MovieManage.getInstance().getMovies()) {
                        if (movie.getTitle().equalsIgnoreCase(movietitle)) {
                            searchedMovie = movie;
                            break;
                        }
                    }
                    if (searchedMovie == null) {
                        System.out.println("movie not found");
                        homePage();
                    } else {
                        System.out.println("1.remove this movie\n2.edit actors\n3.edit writers\n4.edit directors\n5.view and edit reviews");
                        String javab = scanner.nextLine();
                        switch (javab) {

                            case "1": {
                                MovieManage.getInstance().DeleteMovie(searchedMovie);
                            }
                            break;
                            case "2": {
                                System.out.println("1.add an actor\n2.remove an actor");
                                String ans = scanner.nextLine();
                                if (ans.equalsIgnoreCase("1")) {
                                    System.out.println("enter the name of the actor to remove");
                                    String actorName = scanner.nextLine();
                                    System.out.println("enter the last name of the actor to remove");
                                    String actorLastName = scanner.nextLine();
                                    for (RoleInMovie role : searchedMovie.getRolesInMovie()) {
                                        if (role.getMovieRole().equals(MovieRole.ACTOR)) {
                                            if (role.getPerson().getName().equalsIgnoreCase(actorName) && role.getPerson().getLastName().equalsIgnoreCase(actorLastName)) {
                                                searchedMovie.getRolesInMovie().remove(role);
                                                break;
                                            }
                                        }
                                    }
                                } else if (ans.equalsIgnoreCase("2")) {
                                    System.out.println("enter the name of the actor to add");
                                    String actorNameToAdd = scanner.nextLine();
                                    System.out.println("enter the lastName of the actor to add");
                                    String actorLastNameToAdd = scanner.nextLine();
                                    // bebinim to persona hast ya bayad besazimesh
                                    for (Person person : MemberService.getPeople()) {
                                        if (person.getName().equalsIgnoreCase(actorNameToAdd) && person.getLastName().equalsIgnoreCase(actorLastNameToAdd)) {
                                            searchedMovie.addActor(person);
                                        }
                                    }
                                    // persono besaz agar nabood
                                    Person newActor = new Person(actorNameToAdd, actorLastNameToAdd);
                                    searchedMovie.addActor(newActor);
                                }

                            }
                            break;

                            case "3": {
                                System.out.println("1.add a writer\n2.remove a writer");
                                String ans = scanner.nextLine();
                                if (ans.equalsIgnoreCase("1")) {
                                    System.out.println("enter the name of the writer to remove");
                                    String writerName = scanner.nextLine();
                                    System.out.println("enter the last name of the writer to remove");
                                    String writerLastName = scanner.nextLine();
                                    for (RoleInMovie role : searchedMovie.getRolesInMovie()) {
                                        if (role.getMovieRole().equals(MovieRole.WRITER)) {
                                            if (role.getPerson().getName().equalsIgnoreCase(writerName) && role.getPerson().getLastName().equalsIgnoreCase(writerLastName)) {
                                                searchedMovie.getRolesInMovie().remove(role);
                                                break;
                                            }
                                        }
                                    }
                                } else if (ans.equalsIgnoreCase("2")) {
                                    System.out.println("enter the name of the writer to add");
                                    String writerName = scanner.nextLine();
                                    System.out.println("enter the lastName of the writer to add");
                                    String writerLastNameToAdd = scanner.nextLine();
                                    // bebinim to persona hast ya bayad besazimesh
                                    for (Person person : MemberService.getPeople()) {
                                        if (person.getName().equalsIgnoreCase(writerName) && person.getLastName().equalsIgnoreCase(writerLastNameToAdd)) {
                                            searchedMovie.addWriter(person);
                                        }
                                    }
                                    // persono besaz agar nabood
                                    Person newActor = new Person(writerName, writerLastNameToAdd);
                                    searchedMovie.addWriter(newActor);
                                }
                                break;
                            }

                            case "4": {
                                System.out.println("1.add a director\n2.remove a director");
                                String ans = scanner.nextLine();
                                if (ans.equalsIgnoreCase("1")) {
                                    System.out.println("enter the name of the director to remove");
                                    String directorName = scanner.nextLine();
                                    System.out.println("enter the last name of the director to remove");
                                    String directorLastName = scanner.nextLine();
                                    for (RoleInMovie role : searchedMovie.getRolesInMovie()) {
                                        if (role.getMovieRole().equals(MovieRole.DIRECTOR)) {
                                            if (role.getPerson().getName().equalsIgnoreCase(directorName) && role.getPerson().getLastName().equalsIgnoreCase(directorLastName)) {
                                                searchedMovie.getRolesInMovie().remove(role);
                                                break;
                                            }
                                        }
                                    }
                                } else if (ans.equalsIgnoreCase("2")) {
                                    System.out.println("enter the name of the director to add");
                                    String directorName = scanner.nextLine();
                                    System.out.println("enter the lastName of the director to add");
                                    String directorLastNameToAdd = scanner.nextLine();
                                    // bebinim to persona hast ya bayad besazimesh
                                    for (Person person : MemberService.getPeople()) {
                                        if (person.getName().equalsIgnoreCase(directorName) && person.getLastName().equalsIgnoreCase(directorLastNameToAdd)) {
                                            searchedMovie.addDirector(person);
                                        }
                                    }
                                    // persono besaz agar nabood
                                    Person newActor = new Person(directorName, directorLastNameToAdd);
                                    searchedMovie.addWriter(newActor);
                                }
                                break;

                            }

                            case "5": {
                                searchedMovie.displayReviews();
                                System.out.println("Select the review number you want to delete: ");
                                int reviewNumberToDelete = scanner.nextInt();
                                searchedMovie.deleteReview(reviewNumberToDelete);
                                break;// view reviews and delete the specific number

                            }
                        }
                    }
                    break;
                }


                case "3": {// remove a person from data base
                    System.out.println("enter the name of the person you want to remove:");
                    String nameToRemove = scanner.nextLine();
                    System.out.println("enter the last name of the person you want to remove:");
                    String LastNameToRemove = scanner.nextLine();
                    for (Person person : MemberService.getPeople()) {
                        if (person.getName().equalsIgnoreCase(nameToRemove) && person.getLastName().equalsIgnoreCase(LastNameToRemove)) {
                            MemberService.removePerson(person);
                            break;
                        }
                    }
                    break;
                }
                case "4": { // add a person
                    System.out.println("enter the name of the person to add");
                    String nameToAdd = scanner.nextLine();
                    System.out.println("enter the last name of the person to add");
                    String LastNameToAdd = scanner.nextLine();
                    Person person = new Person(nameToAdd, LastNameToAdd);
                    System.out.println("person added successfully");
                    break;
                }


                case "0": {
                    logout();
                    break;
                }


                case "-1": {
                    System.exit(0);
                }

                case "5": {
                    while (true) {

                        System.out.println("press 0 to go back.");
                        for (EditSuggestion suggestion : suggestionQue) {
                            Movie originalMovie = (Movie) suggestion.getOriginalValue();
                            Movie suggestedMovie = (Movie) suggestion.getSuggestedValue();

                            /* Display differences between original and suggested movie */
                            suggestion.displayDifferences(originalMovie, suggestedMovie);


                            EditSuggestion selectedSuggestion = suggestionQue.get(0);
                            System.out.println("1.approve\n2.reject");
                            String approveOrNo = scanner.nextLine();

                            if (approveOrNo.equalsIgnoreCase("1")) {
                                for(EditSuggestion suggestions:suggestionQue){
                                    if(suggestions!=selectedSuggestion && suggestions.getOriginalValue().equals(selectedSuggestion.getOriginalValue())){
                                        suggestions.setOriginalValue((Movie) selectedSuggestion.getSuggestedValue());
                                    }
                                }
                                selectedSuggestion.addAndRemove();
                            }

                            suggestionQue.remove(selectedSuggestion);
                            if (suggestionQue.size()==0){
                                break;
                            }

                        }

                       break;
                    }

                    break;
                }
                case "6":{
                    int count = 1;

                    for(Report report: reports){
                        if(reports==null){
                            System.out.println("no report available");
                            break;
                        }
                        else{
                            System.out.println(count+" report on : "+report.getTitle()+"\n"+ "report text: "+report.getText());
                            count++;
                        }
                    }
                    break;
                }
            }

        }
    }

    public static void editorActions() {
        while (true) {
            System.out.println("suggest an edit on:\n1.a movie\n2.go back to homePage");
            String answ = scanner.nextLine();
            switch (answ) {
                case "1": {
                    System.out.println("enter the name of the movie");
                    String movieTitle = scanner.nextLine();
                    Movie result = MovieManage.getInstance().findMovieByTitle(movieTitle);
                    if(result==null){
                        System.out.println("not found");
                        return;
                    }
                    System.out.println("edit:\n1.the title\n2.the genre\n3.the language");
                    String editOn = scanner.nextLine();
                    if (editOn.equals("1")) { // edit the title
                        System.out.println("enter you suggestion for the title");
                        String titleSuggestion = scanner.nextLine();
                        Movie suggestedMovieObject = new Movie(titleSuggestion, result.getGenre(), result.getRelease(), result.getLanguage(), result.getRolesInMovie());
                        EditSuggestion newMovieSuggestion = new EditSuggestion(result,suggestedMovieObject,MovieManage.getInstance().getMovies());
                        suggestionQue.add(newMovieSuggestion);
                        System.out.println("added to the suggestion que successfully! wait for the admin to process it.");
                    }

                    else if(editOn.equals("2")){ // edit the genre
                        System.out.println("enter you suggestion for the genre");
                        String genreSuggestion = scanner.nextLine();
                        Movie suggestedMovie=new Movie(result.getTitle(),genreSuggestion,(result.getRelease()),result.getLanguage(),result.getRolesInMovie());
                        EditSuggestion newMovieSuggestion = new EditSuggestion(result,suggestedMovie,MovieManage.getInstance().getMovies());
                        suggestionQue.add(newMovieSuggestion);
                        System.out.println("added to the suggestion que successfully! wait for the admin to process it.");
                    }

                    else if(editOn.equals("3")){ // edit the language
                        System.out.println("enter your suggestion for the language");
                        String languageSuggestion = scanner.nextLine();
                        Movie suggestedMovie = new Movie(result.getTitle(),result.getGenre(),result.getRelease(),languageSuggestion,result.getRolesInMovie());
                        EditSuggestion newMovieSuggesion = new EditSuggestion(result,suggestedMovie,MovieManage.getInstance().getMovies());
                        suggestionQue.add(newMovieSuggesion);
                        System.out.println("added to the suggestion que successfully! wait for the admin to process it.");
                    }


                    break;
                }

                case "2": {
                    homePage();
                    break;
                }
            }
        }
    }
}






















