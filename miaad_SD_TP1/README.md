Illa Meryeme                                                                                                        
Systèmes distribuées                                                                                                   
   MIAAD                                                                                                             
Promotion: 2023-2025

# Partie 1:

## 1-	Créer l'interface IDao avec une méthode getData() :
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/6a6cc6a4-03e7-4a93-b6d2-605a28807f48)

## 2-	Créer une implémentation de cette interface :
√ Implémentation DaoImpl :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/f90483c2-c2e9-42f9-af60-83e4c6edb7fe)
√ Implémentation DaoImpl2 :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/45a6e073-bf93-409f-999c-b0eccd38c0d1)
 √ Implémentation DaoImplVWS :
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/552236de-1bf2-4629-a3c4-d3f7aeed2531)
 
## 3-	Créer l'interface IMetier avec une méthode calcul :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/57aa8976-d211-45d0-82ae-af3340b62ac8)

## 4-	Créer une implémentation de cette interface en utilisant le couplage faible :
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/d390c35b-6046-44b3-a92f-dbb582b79b52)
 
## 5-	Faire l'injection des dépendances :
♦ Par instanciation statique :
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/57bdb48d-3d60-4c45-8c8f-be4411416e84)
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/e4c11351-7381-4e7c-953a-693f37ecdd4c)
♦ Par instanciation dynamique :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/702264ed-b00d-4ea4-8078-3cc26fad6677)
Le fichier de configuration « config.txt » :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/ea2d4720-7c4e-43dc-bbd2-57ec21cae378)

# Partie 2 :
Au lieu de créer un projet Java, nous créons un projet maven qui contient le fichier pom.xml
L’injection des dépendances en utilisant spring .
Ajouter les dépendances du framework Spring  
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/bb0bdb8e-63bc-4978-985f-860247ed45b2)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/40da02cc-8d1b-4e5c-ac70-42fb861e1adc)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/08f2e865-f4d3-4a7a-9654-48181ce49e0a)

## En utilisant le Framework Spring :
  -  Version XML :
Créer le fichier de configuration « applicationContext.xml » :
Le premier bean sert à créer un objet dao de la classe DaoImpl.
Le deuxième bean sert à créer un objet metier de la classe MetierImpl.
Pour faire l’injection via setter on a utilisé property qui prend le nom dao et fait référence à l’objet dao.
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/f6a20929-d88a-45c2-90d2-8cebca06f479)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/da8c71f3-7ec7-4745-9d44-b1c9bbc0399f)

De la même manière si on veut afficher la version capteurs on modifier le fichier de configuration :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/22d5a2d3-2c4a-4a86-854a-b2ebbd420800)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/1d39f5fb-5432-403a-bafa-92da2ef0aadc)
 
De même pour la version web service :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/eca7cc1e-cbbe-4d9c-be8e-1b924743c8b5)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/57950682-77f4-416e-b8bf-75ff2b135856)          
 -  Version Annotation :
Pour utiliser la version annotation en ajoute l’annotation @Compenent("dao")  pour instancier les classes et utiliser la notation @Autowired pour injecter les dépendances 
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/109c31e0-1d8f-4f6a-9229-f64484bd6d2a)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/3e1c96ee-4c12-4205-8667-b91e91c4a64e)

L’injection via la notation Autowired
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/6f018124-f7bf-44b4-ab58-3253de2248aa)
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/042579f4-df3a-4918-aa51-d5b125462fcc)

L’injection via le constructeur se fait par créer un constructeur qui reçoit un objet de type IDao et cela fait apparaitre une erreur en relation avec la classe Presentation (cette méthode est mieux que Autowired)
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/4a8a6952-b4ad-46ec-ba4b-057b260dceca)

Pour faire l’injection via constructeur dans la version XML
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/9f254b07-e06d-443e-8f20-3a1396fcb271)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/6a199361-5ab0-48ee-9df8-1a07e46dc9f7)
 
L’injection via Autowired donner l’exception de conflit de beans 
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/b2c6ad42-39a6-4f71-91fd-c8ad30b08c00)

D’abord, il faut donner un nom à chaque bean et au niveau de Autowired on ajoute une autre notation qui s’appelle Qualifier pour injecter l’instance selon son nom
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/f3ea2224-618c-476e-8373-f3bf19b48abe)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/af0ffc6b-cc7a-444c-a71c-c00ca6e3263d)
![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/9ee95a1f-52c6-4436-980d-acf12fa56d5c)

Et pour l’injection via le constructeur ce problème ne se pose pas car la première qu’il a trouvée dans les beans qui implémente cette interface il va l’injecter 
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/16cd6c03-a015-48c7-897b-a867a9f13346)

Pour créer un teste unitaire nous avons besoin d’utiliser junit
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/801a0e5e-b613-449d-84cf-e90a38af6920)

Un exemple de teste unitaire
D’abord on créer une classe metier.Calcul
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/bd8176fd-2e57-4eb4-8703-6996e73682aa)

Et on va créer un teste unitaire dans le dossier test selon le nom metier.CalculTest
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/83796938-e9e6-4cc8-a57c-627f54a2fb20)

Les opérations de base de maven sur intellij
-	Compile :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/7ed1eb26-14ac-45b1-8a37-0e0dc02a5d7c)

-	Test :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/4688cf80-064a-4c57-82c0-635ccf4423ea)

-	Package :
 ![image](https://github.com/Meryemeilla/MeryemeIlla_JEE/assets/165611188/cb4fa300-5bd3-442a-8d92-2da64024b9d9)









