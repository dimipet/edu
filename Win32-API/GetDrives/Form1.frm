VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Drive Information"
   ClientHeight    =   2505
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   2505
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   240
      TabIndex        =   2
      Text            =   "Please Choose Drive"
      Top             =   240
      Width           =   3975
   End
   Begin VB.TextBox Text1 
      Height          =   375
      Left            =   240
      TabIndex        =   1
      Top             =   960
      Width           =   3975
   End
   Begin VB.CommandButton cmdGetDrives 
      Caption         =   "Get Information"
      Height          =   375
      Left            =   1440
      TabIndex        =   0
      Top             =   1680
      Width           =   1575
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Private Declare Function GetDriveType Lib "kernel32" Alias "GetDriveTypeA" _
(ByVal nDrive As String) As Long


Private Sub cmdGetDrives_Click()

    'Form1.Print GetDriveType(Text1.Text & ":\")
    'Text1.Text = ""
    'Text1.SetFocus
    
Dim i As Integer
i = GetDriveType(Combo1.Text)
Select Case i
    Case 2
        Text1.Text = "Removable"
    Case 3
        Text1.Text = "Drive Fixed"
    Case Is = 4
        Text1.Text = "Remote"
    Case Is = 5
        Text1.Text = "Cd-Rom"
    Case Is = 6
        Text1.Text = "Ram disk"
    Case Else
        Text1.Text = "Unrecognized"
End Select
    
    
    
    


End Sub

Private Sub Form_Load()
    Combo1.AddItem ("A:\\")
    Combo1.AddItem ("B:\\")
    Combo1.AddItem ("C:\\")
    Combo1.AddItem ("D:\\")
    Combo1.AddItem ("E:\\")
    Combo1.AddItem ("F:\\")
    Combo1.AddItem ("G:\\")
    Combo1.AddItem ("H:\\")
    Combo1.AddItem ("I:\\")
    Combo1.AddItem ("J:\\")
    Combo1.AddItem ("K:\\")
    Combo1.AddItem ("L:\\")
    Combo1.AddItem ("M:\\")
    Combo1.AddItem ("N:\\")
    Combo1.AddItem ("O:\\")
    Combo1.AddItem ("P:\\")
    Combo1.AddItem ("Q:\\")
    Combo1.AddItem ("R:\\")
    Combo1.AddItem ("S:\\")
    Combo1.AddItem ("T:\\")
    Combo1.AddItem ("U:\\")
    Combo1.AddItem ("V:\\")
    Combo1.AddItem ("W:\\")
    Combo1.AddItem ("X:\\")
    Combo1.AddItem ("Y:\\")
    Combo1.AddItem ("Z:\\")

End Sub

