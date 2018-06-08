// Borland C++ Builder
// Copyright (c) 1995, 2002 by Borland Software Corporation
// All rights reserved

// (DO NOT EDIT: machine generated header) 'DialogsToQDialogs.pas' rev: 6.00

#ifndef DialogsToQDialogsHPP
#define DialogsToQDialogsHPP

#pragma delphiheader begin
#pragma option push -w-
#pragma option push -Vx
#include <Forms.hpp>	// Pascal unit
#include <QForms.hpp>	// Pascal unit
#include <Dialogs.hpp>	// Pascal unit
#include <QDialogs.hpp>	// Pascal unit
#include <Windows.hpp>	// Pascal unit
#include <Classes.hpp>	// Pascal unit
#include <SysUtils.hpp>	// Pascal unit
#include <SysInit.hpp>	// Pascal unit
#include <System.hpp>	// Pascal unit

//-- user supplied -----------------------------------------------------------

namespace Dialogstoqdialogs
{
//-- type declarations -------------------------------------------------------
#pragma option push -b-
enum TQDialogFileAttribute { qdfaReadable, qdfaWriteable, qdfaExecutable };
#pragma option pop

typedef Set<TQDialogFileAttribute, qdfaReadable, qdfaExecutable>  TQDialogFileAttributes;

//-- var, const, procedure ---------------------------------------------------
extern PACKAGE bool __fastcall QDialogExecute(Dialogs::TOpenDialog* Dialog, TQDialogFileAttributes FileAttributes = System::Set<TQDialogFileAttribute, qdfaReadable, qdfaExecutable> () );
extern PACKAGE bool __fastcall QSelDirDialogExecute(const AnsiString Caption, AnsiString &Directory, const AnsiString Root = "");

}	/* namespace Dialogstoqdialogs */
using namespace Dialogstoqdialogs;
#pragma option pop	// -w-
#pragma option pop	// -Vx

#pragma delphiheader end.
//-- end unit ----------------------------------------------------------------
#endif	// DialogsToQDialogs
