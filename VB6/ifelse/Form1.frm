VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Form_Load()

Dim number As Integer

number = 53

If number < 10 Then
    MsgBox "1 digits"
ElseIf number < 100 Then
    MsgBox "2 digits"
Else
    MsgBox "3 digits"
End If

'If digits = 1 Then myString = "One" Else myString = "More than one"

End Sub
