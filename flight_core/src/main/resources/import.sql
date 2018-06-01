INSERT INTO Localite(id , ville , aeroport)  VALUES ( 1 , 'Paris' , 'Paris-Orly' )
INSERT INTO Localite(id , ville , aeroport)  VALUES ( 2 , 'Paris' , 'Paris-Roissy' )
INSERT INTO Localite(id , ville , aeroport)  VALUES ( 3 , 'Toulouse' , 'Toulouse-Blagnac' )
INSERT INTO Localite(id , ville , aeroport)  VALUES ( 4 , 'Nice' , 'Nice-' )

INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 1 , 100.0 , 1 ,  '2017-09-20 18:10:00' , 3 , '2017-09-20 19:30:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 2 , 110.0 , 3 ,  '2017-09-20 08:10:00' , 1 , '2017-09-20 09:20:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 3 , 80.0  , 1 ,  '2018-09-20 12:20:00' , 4 , '2018-09-20 13:30:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 4 , 70.0  , 4 ,  '2018-09-20 20:30:00' , 1 , '2018-09-20 21:15:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 5 , 90.0  , 1 ,  '2018-09-20 18:20:00' , 4 , '2018-09-20 19:30:00' )
INSERT INTO Vol(num , prix , refLocDepart,dateTimeDepart, refLocArrivee,dateTimeArrivee) VALUES ( 6 , 60.0  , 4 ,  '2018-09-20 22:30:00' , 1 , '2018-09-20 23:15:00' )

INSERT INTO Personne(id,typePersonne,firstName , lastName  ,email , phoneNumber)  VALUES (1,'Client','alex' , 'Therieur'  , 'alex-therieur@iciOulaBas.fr' , '0102030405')
INSERT INTO Personne(id,typePersonne,firstName , lastName  ,email , phoneNumber)  VALUES  (2,'Client','alain' , 'Therieur' , 'alain-therieur@xyz.fr' , '0123456789')
INSERT INTO Personne(id,typePersonne,firstName , lastName  ,email , phoneNumber)  VALUES  (3,'Personne','p1' , 'NomQuiVaBien' , 'p1@xyz.fr' , '0123456789')
   
INSERT INTO Adresse(idAdresse,rue,codePostal,ville) VALUES (1,'rue 1','75001','Paris')
INSERT INTO Adresse(idAdresse,rue,codePostal,ville) VALUES (2,'rue 2','69000','Lyon')

INSERT INTO Login(id , username , password)  VALUES ( 1 , 'alex-therieur' , 'pwd007' )
INSERT INTO Login(id , username , password)  VALUES ( 2 , 'alain-therieur' , 'pwd007' )
   
INSERT INTO Resa(idResa, idClient , idVol , dateResa , comment)  VALUES (1, 1 ,1, '2017-08-15' , 'resa aaa' )
INSERT INTO Resa(idResa, idClient , idVol , dateResa , comment)  VALUES (2, 1 ,2, '2017-08-17' , 'resa bbb' )

INSERT INTO Resa_Personne (idResa, idPers )  VALUES (1, 1 )
INSERT INTO Resa_Personne (idResa, idPers )  VALUES (1, 4 )
INSERT INTO Resa_Personne (idResa, idPers )  VALUES (2, 2 )