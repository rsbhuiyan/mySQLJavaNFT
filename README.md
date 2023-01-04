# mySQLJavaNFT
Practice with mySQL and Java that mimics the functions of NFTs (not actual nfts) where users can log in to a server and exchange pictures either by purchasing one or transferring them and many more features.

# Full description
In this project, I didnt implement real NFTs, but a simulation of NFTs. Only registered user can buy and sell NFTs. Each user is identified by a userid, which must be an email (except the root user, whose userid is  simply  “root”),  first  name,  last  name,  birthday,  and  address  (street  number,  street,  city, state, and zip code). Each NFT is identified by a unique NFTID, a unique name, a description, and  an  image  that  is  associated  with  the  NFT.  A  user  can  create  an  NFT (called  minting)  by filling out a web form with a name, a description and an image of the NFT. The system will automatically generate an NFT ID for the NFT and then assign the creator as the current owner of the NFT. At any point, the current owner of an NFT can list the NFT for sale, by specifying the price of the NFT in terms of eth (the unit for crypto Ethereum) and the duration of the listing (one month or two months, for example). Each NFT has exactly one owner at each time point  but  the  ownership  can  be  transferred  from  one  person  to  another  by  two  activities: selling or transfer. A user can search the website for those NFTs that are listed for sale. For simplicity, the search will be based on keywords that will match the names of NFTs. The search results will show all the NFTs that match the search keywords, and those NFTs that are listed for sale will have both price and the buy button. and the user can navigate to examine each NFT in detail, reading the NFT ID, name, description,  and the image, and the current price. If the user likes an NFT, then the user can click the buy button and purchase the NFT. When a user signs up for the website, an initial balance of 100 eth will be given to each user. After sale, the ownership of the NFT will be transferred from the seller to the buyer. Meanwhile, 
the amount of eth will be transferred from the buyer to the seller according to the price of the NFT. An NFT can also be transferred from one user to another for free, in this case, the ownership will be transferred but no money transfer will be involved. We will maintain all the records  for  minting,  selling, and transfer in the  database. The  following  interfaces  will  be implemented: 
1)  Profile  page  (one  for  each  user):  each  user’s  information  including  the balance of each user and NFTs that the user owns.
2) NFT page (one for each NFT): list all the information of an NFT, including NFT ID, name, description, image, and all the activities regarding an NFT from minting, to transferring, to selling.

# features
- The website root user has a username “root” and password “pass1234” 

- For root user, implement a button called “Initialize Database”. This button will only be displayed 
after the root user signed in successfully. Each time the root user clicks the “Initialize Database” 
button, the following events will happen: 1) delete all existing tables (probably 5-10 tables) in 
the database automatically, 2) create all tables necessary for this project; and 3) each table will 
be inserted with at least 10 realistic tuples (which is hard-coded in your Java program).

- Implemented a user registration and login interface so that only a registered user can login into 
the  system.  Sign  up  for  a  new  user  with  information  such  as:  username  (which  is  an  email), 
password,  password  confirmed,  first  name,  last  name,  age.  Duplicate  username  should  be 
detected and fail the signup. Unmatching passwords should be detected as well. 

- Implemented a web interface so that a user (mint) or create an NFT. The user will need to give a name, a description of the NFT and upload an 
image (alternatively, give a URL of the image). After creation, the user will become the first 
owner. 

- Implemented a web interface so that a user can transfer an NFT that the users owns to another 
user. 

- Implemented a web interface so that a user can search existing NFTs by their names. 

- Implemented a web interface so that after searching, a user can buy a listed NFT. 

- Implemented a web interface so that a user can search other users by their IDs.

- Implemented a web interface so that after searching NFTs, a user can click an NFT result and 
see the NFT page. See the project description about what information needs to be included in 
the NFT page. 

- Implemented a web interface to list all the NFTs that were minted by the current 
user.  

- Implemented a web interface to list all the NFTs that have been purchased by the current user. 

- Implemented a web interface to list all the NFTs that have been sold by the current user.  

-  List the users who created the most number of NFTs. List one user if there is 
no tie, list all the top users if there is a tie.

- List  the user who sold the most number of NFTs.  List one user if there is no 
tie, list all the top users if there is a tie.

- List the buyer that purchased the most number of NFTs.  List one user if there 
is no tie and list all top users if there is a tie. 

- List the NFTs who have the most number of owners in the history. List one 
NFT if there is no tie and list all top NFTs if there is a tie.  

- Given two users, X, and Y, which are specified by the user with two 
dropdown menu lists, list the common NFTs that both users  have been an owner of the NFTs 
at some point.

- List the users who purchased some NFTs and then have never sold them 
afterwards. 

- list the users who have purchased some NFTs but have sold all of them (not 
transferred).

- List the users who have purchased at least 3 NFTs.  

- List those users who have never performed NFT activities (minting, buying, 
selling, and transferring)

- Given a user X, list the total numbers of buys, sells, transfers, and the number of 
NFTs that the user owns now. 

