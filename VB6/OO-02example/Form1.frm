VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3195
   ClientLeft      =   3150
   ClientTop       =   1950
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   Begin VB.TextBox Text1 
      Height          =   495
      Left            =   360
      TabIndex        =   0
      Text            =   "Text1"
      Top             =   1800
      Width           =   3615
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
'http://www.visualbasicbooks.com/progVB6samplepg1.html

Private Sub Form_Load()
    Dim pers As Person  'Declare.
    Set pers = New Person 'Create.
    'pers.FirstName = "John" 'Assign properties.
    'pers.LastName = "Smith"
    'Text1.Text = pers.FirstName & " " & pers.LastName 'Check that it works.
    pers.FirstName = "Dimitrios"
    pers.Message
    
    'Set pers.m_Car = New Car
    pers.m_Car.Brand = "Skoda"
    pers.m_Car.Doors = 5
    pers.m_Car.Speed = 160
    
    
    
    
    
    
    
    
End Sub

