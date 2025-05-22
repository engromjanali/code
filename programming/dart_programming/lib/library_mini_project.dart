
void main()
{
  Library library = Library();
  library.addBook(677844, "it's me Romjan Ali", Title:"larn about romjan", Author : "Md Romjan Ali");
  library.addBook(677844, "D Web", Title:"About Dark Web", Author : "Md Sakil");

  library.addMember("md romjan ali", 677844, Age:21);
  library.addMember("shamim", 677840);
  library.addMember("kapil uddin", 677829, Age:19);

  Member mm = library.member[0];
  Book bk = library.book[0];

  library.memberList();
  library.bookList();

  library.issueBook(library.member[0], library.book[0]);
  library.lonList();

  library.returnBook(library.lons[0]);
  library.lonList();
}
 
class Library {
  List<Book> book = [];
  List<Member> member = [];
  List<Lons> lons = [];
  
  void bookList(){
    print("The All Book List is Here: -");
    for(Book book in book){
      print("BookId :  ${book.BookId}  Book Name : ${book.Name} Book Title : ${book.Title} Book Author : ${book.Author} Availabe : ${book.Available}");
    }
  }
  
  void memberList(){
    print("The All Member List is Here: -");
    for(Member member in member){
      print("Name :  ${member.Name} Roll : ${member.Roll} Age : ${member.Age}");
    }
  }
  
  void lonList(){
    print("The All Lon List is Here: -");
    for(Lons lon in lons){
      print("Member Name : ${lon.members.Name} Memeber Id/Roll :  ${lon.members.Roll} Issue/Lon date : ${lon.issueTime} Return Date : ${lon.returnTime}");
    }
  }

  void addBook(int bookId, String bookName, {String Title ="", String Author="",bool Available=true})
  {
    Book bk = Book(BookId: bookId, Name: bookName, Title: Title, Author: Author,Available: Available);
    book.add(bk);
  }

  void addMember(String name, int roll, {int Age = -99})
  {
    Member mm = Member(Name: name, Roll: roll, Age: Age);
    member.add(mm);
  }

  void issueBook(Member member, Book book,{DateTime? datetime}){// we can't assign here default time
    datetime ??= DateTime.now();// assign here default value.
    Lons lon = Lons(member, book, datetime);
    lons.add(lon);
  }

  void returnBook(Lons lon, {DateTime? datetime}){// we can't assign here default time
    datetime ??= DateTime.now();// assign here default value.
    lon.returnBook(datetime: datetime);
  }
}

class Book{
  String? Name;
  String? Title;
  String? Author;
  int? BookId;
  bool? Available;
  Book({required this.BookId, required this.Name, this.Title, this.Author, this.Available = true});
}

class Member{
  String? Name;
  int? Age;
  int? Roll;
  Member({required this.Name, required this.Roll, this.Age});
}

class Lons{
  Member members;
  Book book;
  DateTime? issueTime;
  DateTime? returnTime;

  Lons(this.members, this.book, [this.issueTime]); // here we are passing datetime as array/list.

  void returnBook({DateTime? datetime}){
    book.Available = true;
    returnTime = DateTime.now();
  }
}
