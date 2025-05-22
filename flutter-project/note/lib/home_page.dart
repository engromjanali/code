import 'package:note/data/local/db_helper.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  ///controllers
  TextEditingController titleController = TextEditingController();
  TextEditingController descController = TextEditingController();

  List<Map<String, dynamic>> allNotes = [];
  DBHelper? dbRef;

  @override
  void initState() {
    super.initState();
    dbRef = DBHelper.getInstance;
    getNotes();
  }

  void getNotes() async {
    allNotes = await dbRef!.getAllNote();
    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.grey,
        title: Text('Notes'),
      ),

      /// all notes viewed here
      body: allNotes.isNotEmpty
          ? ListView.builder(
          itemCount: allNotes.length,
          itemBuilder: (_, index) {
            return Card(
              color: Colors.amber.shade100,
              child: ListTile(
                // leading: Text('${index+1}'),
                leading: Text('${allNotes[index][DBHelper.noteNo]}'),
                title: Text(allNotes[index][DBHelper.noteTitle]),
                subtitle: Text(allNotes[index][DBHelper.noteDesc]),
                trailing: SizedBox(
                  width: 50,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text("",style: TextStyle(fontSize: 12),),
                      InkWell(
                          onTap: () {
                            titleController.text = allNotes[index]
                            [DBHelper.noteTitle];
                            descController.text = allNotes[index]
                            [DBHelper.noteDesc];
                            print(DBHelper.noteNo);
                            // print(allNotes[index][DBHelper.noteNo]+DBHelper.noteNo);
                            showModalBottomSheet(
                              isScrollControlled: true,
                                context: context,
                                builder: (context) {
                                  return Container(
                                    padding: EdgeInsets.only(
                                    bottom: MediaQuery.of(context).viewInsets.bottom, // return keyboard size if open, and it's valid for all widget what like keyboard 
                                  ),
                                    // height: 600, // if i use size here height we get fix height otherwise we gat what size has taken by child
                                    child: SingleChildScrollView(
                                      child: getBottomSheetWidget(
                                          isUpdate: true,
                                          sno: allNotes[index]
                                          [DBHelper.noteNo],
                                      ),
                                    ),
                                  );
                                });
                          },
                          child: Icon(Icons.edit)),
                      InkWell(
                        onTap: ()async{
                          bool confirm =await showConfirmDialog(context: context, title: "Do you want to delete This note?");
                          if(confirm){
                            bool check = await dbRef!.deleteNote(sl_no: allNotes[index][DBHelper.noteNo]);
                            if(check){
                              getNotes();
                            }
                          }
                        },
                        child: Icon(
                          Icons.delete,
                          color: Colors.red,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            );
          })
          : Center(
        child: Text('No Notes yet!!'),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          /// note to be added from here
          titleController.clear();
          descController.clear();
          showModalBottomSheet(
  isScrollControlled: true,
  context: context,
  builder: (context) {
    return Padding(
      padding: EdgeInsets.only(
        bottom: MediaQuery.of(context).viewInsets.bottom,// by this padding we are fixing the keyboard ovarlapping, when keyboard open it return keyboard size. it's will be valid for snackber, etc
      ),
      child: SingleChildScrollView(
        child: getBottomSheetWidget(),
      ),
    );
  },
);
        },
        child: Icon(Icons.add),
      ),
    );
  }

  Widget getBottomSheetWidget({bool isUpdate = false, int sno = 0}) {
    return Container(
      padding: EdgeInsets.all(11),
      width: double.infinity,
      child: Column(
        children: [
          // SizedBox(
          //   height: 777,
          // ),
          Text(
            isUpdate ? 'Update Note' : 'Add Note',
            style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
          ),
          SizedBox(
            height: 21,
          ),
          TextField(
            controller: titleController,
            enabled: true,
            decoration: InputDecoration(
              
                hintText: "Enter title here",
                label: Text('Title'),
                focusedBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(11),
                ),
                enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(11),
                )
              ),
          ),
          SizedBox(
            height: 11,
          ),
          TextField(
            controller: descController,
            maxLines: 4,
            decoration: InputDecoration(
                hintText: "Enter desc here",
                label: Text('Desc'),
                focusedBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(11),
                ),
                enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(11),
                )),
          ),
          SizedBox(
            height: 11,
          ),
          Row(
            children: [
              Expanded(
                  child: OutlinedButton(
                      style: OutlinedButton.styleFrom(
                          side: BorderSide(width: 1),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(11))),
                      onPressed: () async {
                        var title = titleController.text;
                        var desc = descController.text;
                        if (title.isNotEmpty || desc.isNotEmpty) {
                          bool check = isUpdate
                              ? await dbRef!.updateNote(
                              title: title, desc: desc, sl_no: sno)
                              : await dbRef!
                              .addNote(title: title, desc: desc);
                          if (check) {
                            getNotes();
                          }
                        } else {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                              content: Text(
                                  'Please fill all the required blanks!!')));
                        }

                        titleController.clear();
                        descController.clear();

                        Navigator.pop(context);
                      },
                      child: Text(isUpdate ? 'Update Note' : 'Add Note'))),
              SizedBox(
                width: 11,
              ),
              Expanded(
                  child: OutlinedButton(
                      style: OutlinedButton.styleFrom(
                          side: BorderSide(width: 1),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(11))),
                      onPressed: () {
                        Navigator.pop(context);
                      },
                      child: Text('Cancel')))
            ],
          )
        ],
      ),
    );
  }
}



 Future<bool> showConfirmDialog({required BuildContext context, required String title}) async{
    bool? res =  await showDialog(context: context, builder: (context) => AlertDialog(
      title: Text(title),
      actions: [
        TextButton(
          onPressed: (){
            Navigator.pop(context, false);
          },
          child:Text("No"),
        ),
        TextButton(
          onPressed: (){
            Navigator.pop(context, true);
          },
          child:Text("Yes"),
        ),
      ],
    ));
    return res?? false;
  }