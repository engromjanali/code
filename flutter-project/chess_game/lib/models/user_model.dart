import 'package:chess_game/constants.dart';

class UserModel{
  String uId;
  String name;
  String email;
  String image;
  String createdAt;
  int userRating;

  UserModel({
    required this.uId,
    required this.name,
    required this.email,
    required this.image,
    required this.createdAt,
    required this.userRating,
  });

  Map<String, dynamic> toMap(){
    return {
      Constants.uId : uId,
      Constants.name : name,
      Constants.email : email,
      Constants.image : image,
      Constants.createdAt : createdAt,
      Constants.userRating : userRating,
    };
  }

  factory UserModel.fromMap(Map<String, dynamic>data){ // like a constructor but it don't create duplicate instance it return existed instance
    return UserModel(
      uId: data[Constants.uId]?? "",
      name: data[Constants.name]?? "",
      email: data[Constants.email]?? "",
      image: data[Constants.image]?? "",
      createdAt: data[Constants.createdAt]?? "",
      userRating: data[Constants.userRating]?? 1200,
    );
  }
}