package src.CinemaManagment;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import javax.swing.text.Document;

import src.Cafe.*; //Paweł dodaj do tego
import src.Reservations.*; //paweł do tego też dodaj (bez filmów bo to już jest)
import src.People.*;
public class SampleData {
    public static void createSampleCustomers() throws NoSuchAlgorithmException{
        Customers c1 = new Customers("Veera", "De Leon", 11, 9, 2001, "WTC2001!", "boeingLover@gmail.eu", 'm');
        Customers c2 = new Customers("Shreya", "Berry", 15, 11, 1999, "QWEERTY2!", "yes@auto.vroom", 'f');
        Customers c3 = new Customers("Lilly", "O'Quinn", 1, 1, 1970, "Lilyofthevalley22!", "lily@interia.eu", 'f');
        Customers c4 = new Customers("Lina", "Mcpherson", 29, 3, 1988, "eH2fVz(M", "devan.yang@hotmail.com", 'f');
        Customers c5 = new Customers("Alexandra", "Lam", 31, 7, 2003, "a!7=yq[X", "jaida.stein@outlook.com", 'm');
        Customers c6 = new Customers("Lucie", "Rowland", 19, 2, 1996, "k*h$Vee9", "pvlvbonfwvn@outlook.com", 'm');
        Customers c7 = new Customers("Tessa", "Oconnell", 11, 9, 1999, "ty8VZ*N&", "arthur.mooney@ymail.com", 'm');
        Customers c8 = new Customers("Rachael", "Marquez", 11, 12, 1987, "q6ZHA{6x", "leo.mullins@msn.com", 'm');
        Customers c9 = new Customers("Rory", "West", 31, 10, 1984, "A%zSV?2>", "brogan.dotson@yahoo.com", 'm');
        Customers c10 = new Customers("Isabel", "Weeks", 19, 1, 1999, "J!H!9=ru", "x1xvbii5xqvwb@googlemail.com", 'm');
        Customers c11 = new Customers("Bonnie", "Vaughn", 1, 5, 1985, "njlgnaNJDES1323", "bret.leach@rediffmail.com", 'f');
        Customers c12 = new Customers("Nancy", "Reyes", 9, 7, 1967, "jgnrwlg#jn34", "gxq3h05emnubt1@googlemail.com", 'm');
        Customers c13 = new Customers("Hayden", "Pennington", 1, 2, 2001, "ILoveFluffyKittens25!@", "boeingLovre@gmail.eu", 'm');
        Customers c14 = new Customers("India", "Nunez", 2, 1, 2002, "meowMeow123@", "gallagher.rasmussen@aol.com", 'm');
        Customers c15 = new Customers("Mckenzie", "Preston", 3, 7, 2001, "Qwertq2!", "vyexqcwppft8yo@yahoo.com", 'm');
        Customers c16 = new Customers("Tilly", "Geer", 4, 4, 2001, "nyanyanyaNya1234NYA@@", "kal-el.hayden@rediffmail.com", 'f');
        Customers c17 = new Customers("Eric", "Cartman", 5, 10, 2001, "yeyeyeyeyey1234YE!", "1v1bsuquodevba@googlemail.com", 'm');
        Customers c18 = new Customers("Power", "ChainsawMan", 5, 11, 2002, "coolPassword234!", "s31fpctqgvgv9jr7@aol.com", 'm');
        Customers c19 = new Customers("Reze", "RussianSpy", 6, 11, 2005, "amIrightLol12!", "joshua.gonzalez@comcast.net", 'm');
        Customers c20 = new Customers("Kyle", "Dobrowski", 15,12, 2006, "lol123@", "d74x8c09kaf2@hotmail.com", 'm');
        Customers c21 = new Customers("Kenny", "OMG", 18, 11, 2001, "password@!2", "leo.mullins@msn.com", 'f');
        Customers c22 = new Customers("Another", "Reference", 22, 3, 2007, "moviestarplanet12#", "di3zq7o5micuc60fds@outlook.com", 'm');
        Customers c23 = new Customers("Token", "Black", 11, 9, 2001, "butters!2", "di3zq7o5micuc60fds@outlook.com", 'f');
        Customers c25 = new Customers("Sonic", "The hedgehog", 11, 9, 2001, "kylesmom1sAb8!", "kiegan.norman@msn.com", 'm');
        Customers c26 = new Customers("shadow", "The Hedgehog", 11, 9, 2001, "EricCartman123!@", "rishi.salinas@aol.com", 'm');
        Customers teto = new Customers("Teto", "Kasane", 1, 4, 2008, "Bguette2008@", "chimera@drills.utau", 'f');
        Cinema.addCustomer(teto);
        Customers konata = new Customers("Konata", "Izumi", 21, 12, 2001, "Meow123!", "luckyStar@gmail.com", 'f');
        Cinema.addCustomer(konata);
        Cinema.addCustomer(c1);
        Cinema.addCustomer(c2);
        Cinema.addCustomer(c3);
        Cinema.addCustomer(c4);
        Cinema.addCustomer(c5);
        Cinema.addCustomer(c6);
        Cinema.addCustomer(c7);
        Cinema.addCustomer(c8);
        Cinema.addCustomer(c9);
        Cinema.addCustomer(c10);
        Cinema.addCustomer(c11);
        Cinema.addCustomer(c12);
        Cinema.addCustomer(c13);
        Cinema.addCustomer(c14);
        Cinema.addCustomer(c15);
        Cinema.addCustomer(c16);
        Cinema.addCustomer(c17);
        Cinema.addCustomer(c18);
        Cinema.addCustomer(c19);
        Cinema.addCustomer(c20);
        Cinema.addCustomer(c21);
        Cinema.addCustomer(c22);
        Cinema.addCustomer(c23);
        Cinema.addCustomer(c26);
        Cinema.addCustomer(c25);
        

    }
    public static void createSampleStaff() throws NoSuchAlgorithmException{
        Staff neru = new Staff("Neru", "Akita", "12345678910", 21, 01, 2007, 'f', "CEO","flipPhoneSupermacy1!");
        Staff s1 = new Staff("Hatsune", "Miku", "54100788786", 11, 03, 2001, 'f', "manager","Leek12MIKUMIKUBEEEEEAM!!!");
        Staff s2 = new Staff("Gackpo", "Camui", "70110224551", 2, 12, 1998, 'm', "HR","MostUnderratedVocaloid23!");
        Staff s3 = new Staff("Kaito", "Shion", "74071325481", 5, 10, 1996, 'm', "manager","Hecool##!80");
        Staff s4 = new Staff("Len", "Kagamine", "52051391224", 8, 3, 1990, 'm', "cleaner","Womenarepretty11!");
        Staff s5 = new Staff("Gumi", "Megpoid", "90081366638", 28, 04, 1976, 'f', "barista","UnderratedQUEEN!!99!");
        Staff s6 = new Staff("Luka", "Megurine", "97102492732", 21, 07, 1965, 'f', "barista","LUKALUKAnighhtFeverrr112!!");
        Staff s7 = new Staff("Kaai", "Yuki", "69051936818", 6, 8, 2007, 'f', "barista","InabakumoriReference#23");
        Staff s8 = new Staff("Aki", "Hayakawa", "06270277212", 15, 10, 2001, 'm', "clerk","Movedtocsmreferenceslol123%");
        Staff s9 = new Staff("Denji", "CSM", "57010524734", 20, 10, 2002, 'f', "clerk","MyGOAT<3");
        Staff s10 = new Staff("Himeno", "CSM", "09221155489", 19, 11, 2001, 'f', "clerk","ModernDayMisato12!");
        Staff s11 = new Staff("Makima", "Mid", "69042466315", 29, 12, 1999, 'f', "cleaner","Midkimachoppedandcooked00!");
        Staff s12 = new Staff("Fumiko", "Mifune", "88010611463", 20, 1, 1950, 'f', "cleaner","Misatobutworse$$2");
        Staff s13 = new Staff("Asa", "Mitaka", "83072526869", 21, 2, 1980, 'f', "cleaner","MeFR<333");
        Staff s14 = new Staff("Yoshida", "Hirofumi", "81080325528", 1, 3, 1981, 'f', "cleaner","LooksJustLikesomeoneIknow11@");
        Staff s15 = new Staff("Akane", "Sawatari", "67081019569", 2, 4, 1978, 'f', "clerk","whowasshe!@3");
        Staff s16 = new Staff("Yuko", "JusticeDevil", "03222411382", 3, 6, 1977, 'f', "clerk","Shewascute<33!");
        Cinema.addStaff(neru);
        Cinema.addStaff(s1);
        Cinema.addStaff(s2);
        Cinema.addStaff(s3);
        Cinema.addStaff(s3);
        Cinema.addStaff(s4);
        Cinema.addStaff(s5);
        Cinema.addStaff(s6);
        Cinema.addStaff(s7);
        Cinema.addStaff(s8);
        Cinema.addStaff(s9);
        Cinema.addStaff(s10);
        Cinema.addStaff(s11);
        Cinema.addStaff(s12);
        Cinema.addStaff(s13);
        Cinema.addStaff(s14);
        Cinema.addStaff(s15);
        Cinema.addStaff(s16);


    }

    public static void createSampleMoviesAndDirectors(){
        Directors Tarantino = new Directors("Quentin", "Tarantino", 3, 27, 1963, 'm', 1994);
        Directors davidFincher = new Directors("David ", "Fincher", 8, 29, 1962, 'm', 1992);
        Directors WesAnderson = new Directors("Wes", "Anderson", 5, 1, 1969, 'm', 1996);
        Directors GarryMarschall = new Directors("Garry", "Marschall", 11, 10, 1934, 'm', 1960);
        Directors AdrianLyne = new Directors("Adrian", "Lyne", 3, 4, 1941, 'm', 1980);
        Directors WesCraven = new Directors("Wes", "Craven", 8, 2, 1939, 'm', 1972);
        Directors jeffFowler = new Directors("Jeff", "Fowler", 7, 27, 1978, 'm', 2022);
        Directors robertLuketic = new Directors("Robert", "Luketic", 10, 1, 1973, 'm', 2001);
        Directors jtMoller = new Directors("JT", "Moller", 1, 30, 1990, 'm', 2005);
        Directors mSchanks = new Directors("Micchael", "Shanks", 8, 10, 1985, 'm', 2006);
        Directors coralieFargeat = new Directors("Coralie", "Fargeat", 10, 24, 1976, 'f', 2017);
        Directors Yoshihara = new Directors("Tatsuya", "Yoshihara", 9, 31, 1988, 'm', 2008);
        Directors jamesWong = new Directors("James", "Wong", 12, 12, 1980, 'm', 2000);
        Directors satoshiKon = new Directors("Satoshi", "Kon", 10, 12, 1963, 'm', 1980);
        Directors villeneuve = new Directors("Denis", "Villeneuve", 10, 3, 1967, 'm', 1980);

        //The only reason I've chosen this topic is because I have a good taste in movies.
        Movies m1 = new Movies(999, "Pulp Fiction", "Pulp Fiction", "comedy", Tarantino, "Eng", true, LocalDate.parse("1994-14-10"), "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", 8.8d);//I get the hype now
        Movies m2 = new Movies(999, "Fenicki Układ", "The Phoenician scheme", "comedy", WesAnderson, "Eng", true, LocalDate.parse("2025-18-05"), "Somehow pulled off the 'nerd takes their glasses off and suddenly is hot' trope' on Michael Cera.", 6.5d);//liked the visuals. Also walter white as Churchill
        Movies m3 = new Movies(1000, "Pretty Woman", "Pretty Woman", "romantic comedy", GarryMarschall, "Eng", true, LocalDate.parse("1990-23-05"), "A corporate raider hires a hooker to act as a business escort in Beverly Hills, California.", 7.9d);//my 2nd fav movie <33
        Movies m4 = new Movies(100, "Krzyk", "Scream", "slasher", WesCraven, "Eng", true, LocalDate.parse("1996-20-12"), "A teen girl reeling from the murder of her mother is targeted by a masked killer obsessed with horror movies.", 5.5d);//Please bring back slashers that don't have demons in them :((
        Movies m5 = new Movies(323, "Fatalne Zauroczenie", "Fatal Atracttion", "thriller", AdrianLyne, "Eng", true, LocalDate.parse("1987-18-09"), "A married man's one-night stand comes back to haunt him when that lover begins to stalk him and his family.", 6.9d);//very good thriller!!! 
        Movies m8 = new Movies(4214, "Podziemny Krąg", "Fight Club", "Thriller", davidFincher, "Eng", true, LocalDate.parse("1999-10-09"), "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.", 10.00d); //I was the critic here. That's my fav movie
        Movies m9 = new Movies(43, "Sonic szybki jak błyskawica", "Sonic The Hedgehog", "comedy", jeffFowler, "Pol", false, LocalDate.parse("2022-20-01"), "Taking refuge on Earth, when Sonic uses his incredible speed and accidentally knock out the power in part of the United States, he catches the attention of Dr. Robotnik and must stop him from using his unique power for world domination.", 5.6d);//I'm a sonic fan ^^
        Movies m10 = new Movies(99, "Sonic 2", "Sonic the hedgehog 2", "comedy", jeffFowler, "Eng", true, LocalDate.parse("2022-08-04"), "When Dr. Robotnik returns with a new partner, Knuckles, in search of an emerald that has the power to destroy civilizations, Sonic teams up with his own sidekick, Tails, on a journey across the world to find the emerald first.", 4.5d);//why not?
        Movies m11 = new Movies(420, "Sonic 3", "Sonic the Hedgehog 3", "comedy", jeffFowler, "Eng", true, LocalDate.parse("2025-06-12"), "Sonic, Knuckles, and Tails reunite against a powerful new adversary, Shadow, a mysterious villain with powers unlike anything they have faced before. With their abilities outmatched, Team Sonic must seek out an unlikely alliance.", 9.5d);//Scored only becuase shadow is there.
        Movies m13 = new Movies(9999, "Legalna Blondynka", "Legally Blonde", "comedy", robertLuketic, "Eng", true, LocalDate.parse("2001-16-10"), "Fashionable sorority queen Elle Woods follows her ex-boyfriend to law school, where she discovers that there is more to her than just looks.", 6.8d);//Elle woods is my role model <33
        Movies m14 = new Movies(940, "Strange Darling", "Strange Darling", "thriller", jtMoller, "Eng", true, LocalDate.parse("2024-30-08"), "A one-night stand at a motel turns into a fight for survival. There's a serial killer and multiple people in their path of destruction.", 8.45d);//UNDERRATED!!!!!!
        Movies m15 = new Movies(940, "Together", "Together", "body horror", mSchanks, "Eng", true, LocalDate.parse("2025-29-08"), "Millie and Tim, a couple already feeling strain in their relationship, move to the countryside to start fresh—but things go profoundly wrong. ", 6.4);//the horror in body horror does not stand for being scary! fun, twisted, worth the while. Tho, not for everyone
        Movies m16 = new Movies(940, "Substancja", "the Substance", "body horror", coralieFargeat, "Eng", true, LocalDate.parse("2024-10-09"), "The two bodies must switch consciousness every seven days without exception, with the inactive body remaining unconscious and fed intravenously", 5.5d);//tries to be deep but failed. Fun watch tho
        Movies m17 = new Movies(940, "Bękarty wojny", "Inglorios basterds", "drama", Tarantino, "Eng", true, LocalDate.parse("2009-01-09"), "follows two parallel plotlines about assassination plots against Adolf Hitler. ", 6.5d);//tarantino has a good taste in fountain pen inks
        Movies m18 = new Movies(940, "Kill Bill", "Kill Bill", "comedy", Tarantino, "Eng", true, LocalDate.parse("2004-10-10"), "After waking from a four-year coma, a former assassin wreaks vengeance on the team of assassins who betrayed her", 8.8d);//I need to finally watch this
        Movies m19 = new Movies(940, "Oszukać przeznaczenie", "final destiantion", "horror", jamesWong, "Eng", true, LocalDate.parse("1994-14-10"), "A high school student has a premonition of his class's flight to Paris exploding upon takeoff, saving himself, five of his classmates and his teacher.", 6.5d);//perfect to watch on a plane
        Movies m20 = new Movies(940, "Oszukać przeznaczenie 2", "Final destination 2", "horror", jamesWong, "Eng", true, LocalDate.parse("1994-14-10"), "When Kimberly has a violent premonition of a highway pileup she blocks the freeway, keeping a few others meant to die, safe...Or are they? ", 4.9d);//fun watch
        Movies m21 = new Movies(940, "Oszukać przeznaczenie 3", "final destination 3", "horror", jamesWong, "Eng", true, LocalDate.parse("1994-14-10"), "A student's premonition of a deadly rollercoaster ride saves her life and a lucky few, but not from Death itself, which seeks out those who escaped their fate. ", 6.9d);//FAV PART!!! I love the humour of it :D
        Movies m22 = new Movies(940, "Oszukać przeznaczenie 4", "final destination 4", "horror", jamesWong, "Eng", true, LocalDate.parse("1994-14-10"), "A horrifying premonition saves a young man and his friends from death during a racetrack accident but terrible fates await them nonetheless.", 4.4d);//CGI aged like milk, not reccomended if you're scared of escalators (i know i am) 
        Movies m23 = new Movies(940, "Oszukać przeznaczenie 5", "final destination 5", "horror", jamesWong, "Eng", true, LocalDate.parse("1994-14-10"), "Death returns to claim the lucky survivors of a deadly bridge collapse in this fifth frightening installment in the series.", 4.4d);//NO TEENAGERS :00!! funfact: initially final destination was supposed to be an X archive episode.
        Movies m24 = new Movies(940, "Oszukać przeznaczenie: więzy krwi", "final destination: bloodlines", "horror", jamesWong, "Eng", true, LocalDate.parse("1994-14-10"), "Plagued by a recurring violent nightmare, a college student returns home to find the one person who can break the cycle and save her family.", 4.6d);//fun watch. 
        Movies m25 = new Movies(940, "Chainsaw man: Reze Movie Arc", "Gekijō-ban Chensō Man Reze-hen", "absolute peak", Yoshihara, "Jap", true, LocalDate.parse("2025-31-09"), "Reze supermacy. Makima is mid.",10.0d);//!!!!!! CAN'T WAIT!!!!!!
        Movies m26 = new Movies(940, "Blade runner 2049", "Blade runner 2049", "sci-fi", Tarantino, "Eng", true, LocalDate.parse("2017-09-09"), "In order to hunt them down, government-sanctioned bounty hunters called “Blade Runners” are recruited to 'retire' the Replicants.", 9.8d);//ryan gosling is me fr
        Movies m27 = new Movies(940, "Perfect Blue", "Pāfekuto burū", "thriller", satoshiKon, "Jap", true, LocalDate.parse("1997-31-10"), "pop singer gives up her career to become an actress, but she slowly goes insane when she starts being stalked by an obsessed fan and what seems to be a ghost ", 8.8d);//ryan gosling is me fr
        Cinema.addMovie(m1);
        Cinema.addMovie(m2);
        Cinema.addMovie(m4);
        Cinema.addMovie(m3);
        Cinema.addMovie(m5);
        Cinema.addMovie(m8);
        Cinema.addMovie(m9);
        Cinema.addMovie(m10);
        Cinema.addMovie(m11);
        Cinema.addMovie(m13);
        Cinema.addMovie(m14);
        Cinema.addMovie(m15);
        Cinema.addMovie(m16);
        Cinema.addMovie(m17);
        Cinema.addMovie(m18);
        Cinema.addMovie(m19);
        Cinema.addMovie(m20);
        Cinema.addMovie(m21);
        Cinema.addMovie(m21);
        Cinema.addMovie(m22);
        Cinema.addMovie(m23);
        Cinema.addMovie(m24);
        Cinema.addMovie(m25);
        Cinema.addMovie(m26);
        Cinema.addMovie(m27);
        ScreeningRooms src1 = new ScreeningRooms(1, 2, 10, 160);
        Program p1 = new Program(13, 20, 31, 10, 2025, m25, src1);
        Seats seat1 = src1.getSeatByNumber(30);
        Customers c1 = Cinema.getCustomerByEmail("boeingLover@gmail.eu");
        Reservation r1 = new Reservation(c1, p1, seat1);
        
        ScreeningRooms src2 = new ScreeningRooms(2, 2, 10, 160);
        Program p2 = new Program(13, 0, 31, 10, 2025, m26, src2);
        Seats seat2 = src2.getSeatByNumber(25);
        Customers c2 = Cinema.getCustomerByEmail("yes@auto.vroom");
        Reservation r2 = new Reservation(c2, p2, seat2);
        
        ScreeningRooms src3 = new ScreeningRooms(1, 2, 10, 160);
        Program p3 = new Program(14, 25, 3, 12, 2025, m1, src3);
        Seats seat3 = src3.getSeatByNumber(12);
        Customers c3 = Cinema.getCustomerByEmail("lily@interia.eu");
        Reservation r3 = new Reservation(c3, p3, seat3);
        
        ScreeningRooms src4 = new ScreeningRooms(1, 2, 10, 160);
        Program p4 = new Program(14, 0, 2, 3, 2025, m23, src4);
        Seats seat4 = src4.getSeatByNumber(5);
        Customers c4 = Cinema.getCustomerByEmail("devan.yang@hotmail.com");
        Reservation r4 = new Reservation(c4, p4, seat4);
        
        ScreeningRooms src5 = new ScreeningRooms(1, 2, 10, 160);
        Program p5 = new Program(16, 30, 31, 10, 2025, m25, src5);
        Seats seat5 = src5.getSeatByNumber(30);
        Customers c5 = Cinema.getCustomerByEmail("jaida.stein@outlook.com");
        Reservation r5 = new Reservation(c5, p5, seat5);
        
        ScreeningRooms src6 = new ScreeningRooms(1, 2, 10, 160);
        Program p6 = new Program(16, 30, 31, 10, 2025, m25, src6);
        Seats seat6 = src6.getSeatByNumber(31);
        Customers c6 = Cinema.getCustomerByEmail("pvlvbonfwvn@outlook.com");
        Reservation r6 = new Reservation(c6, p6, seat6);
        
        ScreeningRooms src7 = new ScreeningRooms(1, 2, 10, 160);
        Program p7 = new Program(16, 30, 31, 10, 2025, m25, src7);
        Seats seat7 = src7.getSeatByNumber(32);
        Customers c7 = Cinema.getCustomerByEmail("arthur.mooney@ymail.com");
        Reservation r7 = new Reservation(c7, p7, seat7);
        
        ScreeningRooms src8 = new ScreeningRooms(1, 2, 10, 160);
        Program p8 = new Program(16, 30, 31, 10, 2025, m25, src8);
        Seats seat8 = src8.getSeatByNumber(33);
        Customers c8 = Cinema.getCustomerByEmail("leo.mullins@msn.com");
        Reservation r8 = new Reservation(c8, p8, seat8);
        
        ScreeningRooms src9 = new ScreeningRooms(1, 2, 10, 160);
        Program p9 = new Program(16, 30, 31, 10, 2025, m25, src9);
        Seats seat9 = src9.getSeatByNumber(34);
        Customers c9 = Cinema.getCustomerByEmail("brogan.dotson@yahoo.com");
        Reservation r9 = new Reservation(c9, p9, seat9);
        
        ScreeningRooms src10 = new ScreeningRooms(1, 2, 10, 160);
        Program p10 = new Program(12, 20, 5, 12, 2025, m13, src10);
        Seats seat10 = src10.getSeatByNumber(3);
        Customers c10 = Cinema.getCustomerByEmail("x1xvbii5xqvwb@googlemail.com");
        Reservation r10 = new Reservation(c10, p10, seat10);
        
        ScreeningRooms src11 = new ScreeningRooms(5, 3, 10, 160);
        Program p11 = new Program(18, 20, 6, 2, 2026, m3, src11);
        Seats seat11 = src11.getSeatByNumber(20);
        Customers c11 = Cinema.getCustomerByEmail("bret.leach@rediffmail.com");
        Reservation r11 = new Reservation(c11, p11, seat11);
       
        ScreeningRooms src12 = new ScreeningRooms(2, 2, 10, 160);
        Program p12 = new Program(17, 30, 24, 3, 2026, m8, src12);
        Seats seat12 = src12.getSeatByNumber(18);
        Customers c12 = Cinema.getCustomerByEmail("gxq3h05emnubt1@googlemail.com");
        Reservation r12 = new Reservation(c12, p12, seat12);
       
        ScreeningRooms src13 = new ScreeningRooms(3, 2, 10, 160);
        Program p13 = new Program(11, 20, 1, 1, 2026, m10, src13);
        Seats seat13 = src1.getSeatByNumber(25);
        Customers c13 = Cinema.getCustomerByEmail("boeingLovre@gmail.eu");
        Reservation r13 = new Reservation(c13, p13, seat13);
       
        ScreeningRooms src14 = new ScreeningRooms(4, 2, 10, 160);
        Program p14 = new Program(15, 0, 9, 11, 2025, m9, src14);
        Seats seat14 = src14.getSeatByNumber(33);
        Customers c14 = Cinema.getCustomerByEmail("gallagher.rasmussen@aol.com");
        Reservation r14 = new Reservation(c14, p14, seat14);
       
        ScreeningRooms src15 = new ScreeningRooms(1, 2, 10, 160);
        Program p15 = new Program(13, 20, 3, 1, 2026, m13, src15);
        Seats seat15 = src15.getSeatByNumber(1);
        Customers c15 = Cinema.getCustomerByEmail("vyexqcwppft8yo@yahoo.com");
        Reservation r15 = new Reservation(c15, p15, seat15);
       
        ScreeningRooms src16 = new ScreeningRooms(1, 2, 10, 160);
        Program p16 = new Program(1, 20, 11, 9, 2026, m24, src16);
        Seats seat16 = src16.getSeatByNumber(3);
        Customers c16 = Cinema.getCustomerByEmail("kal-el.hayden@rediffmail.com");
        Reservation r16 = new Reservation(c16, p16, seat16);
       
        ScreeningRooms src17 = new ScreeningRooms(1, 2, 10, 160);
        Program p17 = new Program(15, 20, 6, 12, 2025, m23, src17);
        Seats seat17 = src17.getSeatByNumber(16);
        Customers c17 = Cinema.getCustomerByEmail("1v1bsuquodevba@googlemail.com");
        Reservation r17 = new Reservation(c17, p17, seat17);

        Cinema.addReservation(r1);
        Cinema.addReservation(r2);
        Cinema.addReservation(r3);
        Cinema.addReservation(r4);
        Cinema.addReservation(r5);
        Cinema.addReservation(r6);
        Cinema.addReservation(r7);
        Cinema.addReservation(r8);
        Cinema.addReservation(r9);
        Cinema.addReservation(r10);
        Cinema.addReservation(r11);
        Cinema.addReservation(r12);
        Cinema.addReservation(r13);
        Cinema.addReservation(r14);
        Cinema.addReservation(r15);
        Cinema.addReservation(r16);
        Cinema.addReservation(r17);


    }
    public static void createSampleFood() {
        Drinks d1 = new Drinks("Pepsi", 20.00, "Gazowany napój o smaku koli", 500, false, "cola", true, "Soda");
        Drinks d2 = new Drinks("Pepsi Max", 20.00, "Gazowany napój o smaku koli bez cukru", 500, false, "cola", false, "Soda");
        Drinks d3 = new Drinks("Lipton lemon ice tea", 19.00, "napój o smaku zimnej cytrynowej herbaty", 500, false, "lemon ice tea", true, "Ice tea");
        Drinks d4 = new Drinks("Lipton lemon ice tea sugar free", 19.00, "napój o smaku zimnej cytrynowej herbaty bez dodatku cukru", 500, false, "lemon ice tea", false, "Ice tea");
        Drinks d5 = new Drinks("Lipton peach ice tea", 19.00, "napój o smaku zimnej brzoskwiniowej herbaty", 500, false, "peach ice tea", true, "Ice tea");
        Drinks d6 = new Drinks("Lipton peach ice tea sugar free", 19.00, "napój o smaku zimnej brzoskwiniowej herbaty bez dodatku cukru", 500, false, "peach ice tea", false, "Ice tea");
        Drinks d7 = new Drinks("Whiskey z kolą", 30.00, "whiskey w swojim ikonicznym połączeniu z kolą", 300, true, "wiskey with coke", true, "Alcohol");
        Drinks d8 = new Drinks("Strawberry slushie", 20.00, "Strawberry slushie", 500, false, "Strawberry slushie", false, "Slushie");
        Drinks d9 = new Drinks("Monster Shlushie", 20.00, "Monster shlushie", 500, true, "Monster slushie", false, "Slushie");
        Cafe.addToDrinks(d1);
        Cafe.addToDrinks(d2);
        Cafe.addToDrinks(d3);
        Cafe.addToDrinks(d4);
        Cafe.addToDrinks(d5);
        Cafe.addToDrinks(d6);
        Cafe.addToDrinks(d7);
        Cafe.addToDrinks(d8);
        Cafe.addToDrinks(d9);
        Snacks s1 = new Snacks("Lays o smaku papryki",20.00,"Chipsy ziemniaczane o smaku papryki",30);
        Snacks s2 = new Snacks("Lays o smaku zielonej cebulki",20.00,"Chipsy ziemniaczane o smaku zielonej cebulki",30);
        Snacks s3 = new Snacks("Nachos",40.00,"nachosy z sosem serowym",80);
        Snacks s4 = new Snacks("Popcorn mały",30.00,"Popcorn z opcją karmel",80);
        Snacks s5 = new Snacks("Popcorn średni",31.00,"Popcorn z opcją karmel",100);
        Snacks s6 = new Snacks("Popcorn duży",35.00,"Popcorn z opcją karmel",190);
        Snacks s7 = new Snacks("żelki misie", 20.00, "żelki w krztałcie misi", 40);
        Cafe.addToSnacks(s1);
        Cafe.addToSnacks(s2);
        Cafe.addToSnacks(s3);
        Cafe.addToSnacks(s4);
        Cafe.addToSnacks(s5);
        Cafe.addToSnacks(s6);
        Cafe.addToSnacks(s7);
        Sets set1 = new Sets("2 for u", "2 for u but in a cinema",s5 ,d2 , 1, 1);
        Sets set2 = new Sets("Mexico", "taco salsa nachos border",s3 ,d2 , 1, 1);
        Sets set3 = new Sets("its cheaper to have a woman or a man than be alone", "for 2 people go kiss now or smth",s4 ,d2 , 2, 2);
        Sets set4 = new Sets("this would slap on god", "trust me",s2 ,d7 , 1, 2);
        Sets set5 = new Sets("masochism", "do you hate your self? like really bro who eats popcorn while drinking peach lipton",s6 ,d6 , 1, 1);
        Sets set6 = new Sets("sugar rush", "you will die unless you got insuline",s7 ,d8 , 1, 1);
        Sets set7 = new Sets("Sleep depravatio", "Either you unlock the 25th hour of the day or just get a heart attack",s4 ,d9 , 1, 1);
        Sets set8 = new Sets("Mexico but alcohol", "taco salsa nachos ALCOHOL",s3 ,d7 , 1, 2);
        Cafe.addToSets(set1);
        Cafe.addToSets(set2);
        Cafe.addToSets(set3);
        Cafe.addToSets(set4);
        Cafe.addToSets(set5);
        Cafe.addToSets(set6);
        Cafe.addToSets(set7);
        Cafe.addToSets(set8);
    }
}
