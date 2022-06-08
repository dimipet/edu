Attribute VB_Name = "Module1"
Public Declare Function FindWindow Lib "user32" Alias "FindWindowA" ( _
ByVal lpClassName As String, _
ByVal lpWindowName As String) As Long

