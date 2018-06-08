/* this file contains the actual definitions of */
/* the IIDs and CLSIDs */

/* link this file in with the server and any clients */


/* File created by MIDL compiler version 5.01.0158 */
/* at Thu May 28 16:58:24 1998
 */
/* Compiler settings for f:\platinum\cdontb2\src\cdo\cdo.idl:
    Os (OptLev=s), W1, Zp8, env=Win32, ms_ext, app_config, c_ext
    error checks: allocation ref bounds_check enum stub_data 
*/
//@@MIDL_FILE_HEADING(  )
#ifdef __cplusplus
extern "C"{
#endif 


#ifndef __IID_DEFINED__
#define __IID_DEFINED__

typedef struct _IID
{
    unsigned long x;
    unsigned short s1;
    unsigned short s2;
    unsigned char  c[8];
} IID;

#endif // __IID_DEFINED__

#ifndef CLSID_DEFINED
#define CLSID_DEFINED
typedef IID CLSID;
#endif // CLSID_DEFINED

const IID IID_IADOStream = {0xD5C7917D,0xB941,0x11D1,{0x9F,0x62,0x00,0x00,0xF8,0x75,0xB2,0xC7}};


const IID IID_IResField = {0xfc23e808,0x9766,0x11d1,{0xaa,0xfd,0x00,0xc0,0x4f,0xc3,0x1d,0x63}};


const IID IID_IResFields = {0x06cb3f3c,0x969e,0x11d1,{0xaa,0xfc,0x00,0xc0,0x4f,0xc3,0x1d,0x63}};


const IID IID_IBodyPart = {0x33D47B92,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const IID IID_IMessage = {0x33D47B91,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const IID IID_IConfig = {0x33D47B93,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const IID IID_IMessages = {0x51624D52,0xB26D,0x11d1,{0x95,0x6F,0x00,0xC0,0x4F,0xC2,0xD6,0x70}};


const IID IID_IDropDirectory = {0x515A6DB9,0xB262,0x11d1,{0x95,0x6F,0x00,0xC0,0x4F,0xC2,0xD6,0x70}};


const IID IID_IBodyParts = {0x33D47B95,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const IID LIBID_CDO = {0x33D47B6D,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const IID IID_ISMTPOnArrival = {0x861E0DD0,0xAEE7,0x11d1,{0x95,0x6C,0x00,0xC0,0x4F,0xC2,0xD6,0x70}};


const IID IID_INNTPOnPost = {0x850BB4D4,0xAEF5,0x11d1,{0x95,0x6C,0x00,0xC0,0x4F,0xC2,0xD6,0x70}};


const IID IID_INNTPOnPostFinal = {0x850BB4D5,0xAEF5,0x11d1,{0x95,0x6C,0x00,0xC0,0x4F,0xC2,0xD6,0x70}};


const CLSID CLSID_Message = {0x33D47B70,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const CLSID CLSID_Config = {0x33D47B72,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const CLSID CLSID_Stream = {0x33D47B73,0x8B95,0x11D1,{0x82,0xDB,0x00,0xC0,0x4F,0xB1,0x62,0x5D}};


const CLSID CLSID_DropDirectory = {0x65F5F799,0xB2C5,0x11d1,{0x95,0x6F,0x00,0xC0,0x4F,0xC2,0xD6,0x70}};


#ifdef __cplusplus
}
#endif
