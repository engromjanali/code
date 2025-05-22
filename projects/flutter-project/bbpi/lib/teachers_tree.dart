import 'package:flutter/material.dart';
import 'package:flutter_simple_treeview/flutter_simple_treeview.dart';

class TeachersTree extends StatefulWidget {
  const TeachersTree({super.key});

  @override
  State<TeachersTree> createState() => _TeachersTreeState();
}

class _TeachersTreeState extends State<TeachersTree> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: SingleChildScrollView(
          scrollDirection: Axis.horizontal,
          child: SingleChildScrollView(
            scrollDirection: Axis.vertical,
            child: Column(
              children: [
                TreeView(
                  nodes: [
                  TreeNode(
                    content: Text("sdfk"),
                  ),
                  TreeNode(
                    content: Text("sdfk"),
                  ),
                  TreeNode(
                    content: Text("sdfk"),
                  ),
                  TreeNode(
                    content: Text("sdfk"),

                  ),
                  TreeNode(
                    content: Container(
                      height: 200,
                      width: 200,
                      color: Colors.amber,
                    ),
                    children: [
                     
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                content: Text("sdfk"),
                children: [
                  
                ]
              ),TreeNode(
                content: Text("sdfk"),
                children: [
                  
                ]
              ),TreeNode(
                content: Text("sdfk"),
                children: [
                  
                ]
              ),TreeNode(
                content: Text("sdfk"),
                children: [
                  
                ]
              ),TreeNode(
                content: Text("sdfk"),
                children: [
                  
                ]
              ),TreeNode(
                content: Text("sdfk"),
                children: [
                  
                ]
              ),
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                    content: Text("sdfk"),
                    children: [
                      TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                  TreeNode(
                  content: Text("sdfk"),
                  children: [
                    
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),  
                  ]
                ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                    ]
                  ),
                ])
              ],
            ),
          ),
        ),
      ),
    );
  }
}