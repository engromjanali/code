import 'dart:io';

import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

class DBHelper{

  DBHelper._(); // we are privation the constructor here.
  static final DBHelper getInstance = DBHelper._(); // first way with final
  // static DbHelper getInstance(){ //  2nd way but we can't male it final but final is fully optional
  //   return DbHelper._();
  // }

  Database? myDB;

  static final tableName = "note";
  static final noteTitle = "title";
  static final noteDesc = "desc";
  static final noteNo = "ls_no";
  static final noteTime = "entry_time";

  // dp open (path -> if exists then open else create db.
  Future<Database> getDB() async{
    myDB??= await openDB();
    return myDB!;
    
  }

  Future<Database> openDB() async{
    Directory appDir = await getApplicationDocumentsDirectory();
    String dbPath = join(appDir.path, "noteDB.db");
    return await openDatabase(dbPath, onCreate:(db, version){
      db.execute("create table  $tableName ($noteNo integer primary key autoincrement, $noteTitle text, $noteDesc text, $noteTime text DEFAULT CURRENT_TIMESTAMP); ");
    },
        version: 1);
  }

  // insert data
  Future<bool> addNote({required String title, required desc})async{
    var db = await getDB();
    // insert into $tablename(noteTitle, noteDesc) values(title,desc);
    int effected_row = await db.insert(
        tableName,
        {
          noteTitle : title,
          noteDesc : desc,
        }
    );
    // print("Inserted Row ID: $effected_row");
    return effected_row>0;
  }

  // fetch all data
  Future<List<Map<String,dynamic>>> getAllNote()async{
    var db = await getDB();
    // select * from note
    List<Map<String,dynamic>>AllData = await db.query(tableName);
    // print("Fetched Notes: $AllData");
    return AllData;
  }

  // Update Data
  Future<bool> updateNote({required String title, required desc, required sl_no})async{
    var db = await getDB();
    // update $tableName set $noteDesc = $desc, $noteTitle = $title where $noteNo = $sl_no;
    int effected_row = await db.update(
        tableName,{
      noteTitle : title,
      noteDesc : desc,
    },
        where: "$noteNo=?",
        whereArgs: [sl_no,]
    );
    return effected_row>0;
  }

  // delete Data
  Future<bool>deleteNote({required int sl_no}) async{
    var db = await getDB();
    // delete from %tableName wehere $noteNo = $sl_no;
    int effected_row = await db.delete(
        tableName,
        where: "$noteNo = ?",
        whereArgs: ["$sl_no"]);
    return effected_row>0;
  }

}