INSERT INTO Localite(id , ville , aeroport)  VALUES ( 1 , 'Paris' , 'Paris-Orly' )
INSERT INTO Localite(id , ville , aeroport)  VALUES ( 2 , 'Paris' , 'Paris-Roissy' )
INSERT INTO Localite(id , ville , aeroport)  VALUES ( 3 , 'Toulouse' , 'Toulouse-Blagnac' )
INSERT INTO Localite(id , ville , aeroport)  VALUES ( 4 , 'Nice' , 'Nice-' )

INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 1 , 100.0 , 1 ,  '2017-09-20 18:10:00' , 3 , '2017-09-20 19:30:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 2 , 110.0 , 3 ,  '2017-09-21 08:10:00' , 1 , '2017-09-21 09:20:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 3 , 80.0  , 1 ,  '2017-09-20 12:20:00' , 4 , '2017-09-20 13:30:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 4 , 70.0  , 4 ,  '2017-09-21 20:30:00' , 1 , '2017-09-21 21:15:00' ) 