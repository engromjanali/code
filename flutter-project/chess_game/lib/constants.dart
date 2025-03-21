import 'package:chess_game/main_screens/game_time_screen.dart';
import 'package:chess_game/main_screens/home_screen.dart';
import 'package:chess_game/models/user_model.dart';

class Constants {
  static const String custom = "Custom";

  static const String homeScreen = "/homeScreen";
  static const String gameScreen = "gameScreen";
  static const String settingScreen = "settingScreen";
  static const String aboutScreen = "aboutScreen";
  static const String gameStartUpScreen = "gameStartUpScreen";
  static const String gameTimeScreen = "gameTimeScreen";
  static const String signInScreen = "/signInScreen";
  static const String signUpScreen = "/signUpScreen";
  static const String userInformationScreen = "/userInformationScreen";
  static const String landingScreen = "/landingScreen";
  static const String offlinePlayScreen = "/offlinePlayScreen";


  static const String uId= "uId";
  static const String name = "name";
  static const String email = "email";
  static const String image = "image";
  static const String createdAt = "createdAt";
  static const String userRating = 'userRating';

  static const String users = "users";
  static const String userImages = "userImages";
  static const String userModel = "userModel";
  static const String isSignedIn = "isSignedIn";
  // static const String playerRating = "playerRating";

  static const String availableGames = 'availableGames';
  static const String photoUrl = "photoUrl";
  static const String gameCreatorUid = "gameCreatorUid";
  static const String gameCreatorName = "gameCreatorName";
  static const String gameCreatorPhoto = "gameCreatorPhoto";
  static const String gameCreatorRating = "gameCreatorRating";
  static const String isPlaying = "isPlaying";
  static const String gameId = "gameId";
  static const String dateCreated = "dateCreated";
  static const String whitesTime = "whitesTime";
  static const String blacksTime = "blacksTime";

  // static const String gameId = "gameId";
  // static const String gameCreatorUid = "gameCreatorUid";
  static const String userId = "userId";
  static const String positionFen = "positionFen";
  static const String winnerId = "winnerId";
  // static const String whitesTime = "whitesTime";
  // static const String blacksTime = "blacksTime";
  static const String whitesCurrentMove = "whitesCurrentMove";
  static const String blacksCurrentMove = "blacksCurrentMove";
  static const String boardState = "boardState";
  static const String playState = "playState";
  static const String isWhitesTurn = "isWhitesTurn";
  static const String isGameOver = "isGameOver";
  static const String squareState = "squareState";
  static const String moves = "moves";

  static const String runningGame = "runningGame";
  static const String game = "game";

  static const String userName = "userName";
  static const String gameScore = "gameScore";


  static const String searchingPlayerText = 'Searching for player, please wait...';
  static const String joiningGameText = 'Joining game, please wait...';

}

enum PlayerColor{
  white, black,
}
enum GameDificulty{
  easy, medium, hard,
}

enum SignType{
  emailAndPassword,
  google,
  guest,
  facebook,
}