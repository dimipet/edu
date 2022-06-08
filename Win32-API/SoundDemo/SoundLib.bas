Attribute VB_Name = "SoundLib"
Option Explicit

Public Enum SoundCommands
   SND_ALIAS = &H10000
   SND_ALIAS_ID = &H110000
   SND_ALIAS_START = 0
   SND_APPLICATION = &H80
   SND_ASYNC = &H1
   SND_FILENAME = &H20000
   SND_LOOP = &H8
   SND_MEMORY = &H4
   SND_NODEFAULT = &H2
   SND_NOSTOP = &H10
   SND_NOWAIT = &H2000
   SND_PURGE = &H40
   SND_RESOURCE = &H40004
   SND_SYNC = &H0
End Enum

Declare Function PlaySound Lib "winmm.dll" _
   Alias "PlaySoundA" (ByVal lpszName As String, _
   ByVal hModule As Long, ByVal dwFlags As Long) As Long

Public Declare Function mciSendString _
   Lib "winmm.dll" Alias "mciSendStringA" _
   (ByVal lpstrCommand As String, _
   ByVal lpstrReturnString As String, _
   ByVal uReturnLength As Long, ByVal hwndCallback As Long) _
   As Long

Declare Function mciGetErrorString _
   Lib "winmm.dll" Alias "mciGetErrorStringA" _
   (ByVal dwError As Long, ByVal lpstrBuffer As String, _
   ByVal uLength As Long) As Long


