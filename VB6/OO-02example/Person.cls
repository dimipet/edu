VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
  Persistable = 0  'NotPersistable
  DataBindingBehavior = 0  'vbNone
  DataSourceBehavior  = 0  'vbNone
  MTSTransactionMode  = 0  'NotAnMTSObject
END
Attribute VB_Name = "Person"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit

Private m_FirstName As String
Private m_LastName As String
Private m_Citizenship As String
Public m_Car As Car
'


' Note that all Property procedures are Public by default.
'
Private Sub Class_Initialize()
    m_Citizenship = "Hellenic"
    Set m_Car = New Car
End Sub

Property Get FirstName() As String
    ' Simply return the current value of the member variable.
    FirstName = m_FirstName
End Property

Property Let FirstName(ByVal newValue As String)
    ' Raise an error if an invalid assignment is attempted.
    If newValue = "" Then Err.Raise 5 ' Invalid procedure argument
    ' Else store in the Private member variable.
    m_FirstName = newValue
End Property
Property Get LastName() As String
    ' Simply return the current value of the member variable.
    LastName = m_LastName
End Property

Property Let LastName(ByVal newValue As String)
    ' Raise an error if an invalid assignment is attempted.
    If newValue = "" Then Err.Raise 5 ' Invalid procedure argument
    ' Else store in the Private member variable.
    m_LastName = newValue
End Property


Function CompleteName() As String
    CompleteName = FirstName & " " & LastName
End Function

Function ReverseName() As String
    ReverseName = LastName & ", " & FirstName
End Function

Sub Message()
    MsgBox (Me.CompleteName)
End Sub
