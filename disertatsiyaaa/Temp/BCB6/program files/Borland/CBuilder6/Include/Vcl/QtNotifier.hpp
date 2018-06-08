// Borland C++ Builder
// Copyright (c) 1995, 2002 by Borland Software Corporation
// All rights reserved

// (DO NOT EDIT: machine generated header) 'QtNotifier.pas' rev: 6.00

#ifndef QtNotifierHPP
#define QtNotifierHPP

#pragma delphiheader begin
#pragma option push -w-
#pragma option push -Vx
#include <Classes.hpp>	// Pascal unit
#include <QTypes.hpp>	// Pascal unit
#include <SysInit.hpp>	// Pascal unit
#include <System.hpp>	// Pascal unit

//-- user supplied -----------------------------------------------------------

namespace Qtnotifier
{
//-- type declarations -------------------------------------------------------
class DELPHICLASS TQSocketNotifier;
class PASCALIMPLEMENTATION TQSocketNotifier : public Qtypes::THandleComponent 
{
	typedef Qtypes::THandleComponent inherited;
	
private:
	int FFileDescriptor;
	bool FEnabled;
	Classes::TNotifyEvent FOnActivated;
	void __cdecl ActivatedHook(int FD);
	void __fastcall SetEnabled(bool Value);
	
protected:
	virtual void __fastcall CreateWidget(void);
	virtual void __fastcall HookEvents(void);
	
public:
	__fastcall TQSocketNotifier(Classes::TComponent* AOwner, int FD);
	__property Classes::TNotifyEvent OnActivated = {read=FOnActivated, write=FOnActivated};
	__property bool Enabled = {read=FEnabled, write=SetEnabled, nodefault};
public:
	#pragma option push -w-inl
	/* THandleComponent.Destroy */ inline __fastcall virtual ~TQSocketNotifier(void) { }
	#pragma option pop
	
public:
	#pragma option push -w-inl
	/* TComponent.Create */ inline __fastcall virtual TQSocketNotifier(Classes::TComponent* AOwner) : Qtypes::THandleComponent(AOwner) { }
	#pragma option pop
	
};


//-- var, const, procedure ---------------------------------------------------
extern PACKAGE TQSocketNotifier* __fastcall CreateNotifier(int FD, Classes::TNotifyEvent ActivatedEvent);

}	/* namespace Qtnotifier */
using namespace Qtnotifier;
#pragma option pop	// -w-
#pragma option pop	// -Vx

#pragma delphiheader end.
//-- end unit ----------------------------------------------------------------
#endif	// QtNotifier
