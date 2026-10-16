"""Render the repository's animated README banner. Requires Pillow."""
from pathlib import Path
import math,random,sys
from PIL import Image,ImageDraw,ImageFont,ImageFilter

ROOT=Path(__file__).resolve().parents[1] if Path(__file__).parent.name=='tools' else Path('work/github-v3-publicacion').resolve()
OUT=ROOT/'assets';OUT.mkdir(parents=True,exist_ok=True)
W,H=1200,400
FONT_DIR=Path('C:/Windows/Fonts')
def font(size,bold=False):
 candidates=[FONT_DIR/('consolab.ttf' if bold else 'consola.ttf'),Path('/usr/share/fonts/truetype/dejavu/DejaVuSansMono.ttf')]
 for p in candidates:
  if p.is_file():return ImageFont.truetype(str(p),size)
 return ImageFont.load_default(size=size)
small=font(17);mono=font(20);body=font(23);title=font(49,True);sub=font(28,True);tagfont=font(17,True)
green=(100,255,172);white=(225,244,237);muted=(115,151,138)
rng=random.Random(73)
columns=[(x,rng.randrange(H),rng.uniform(.5,1.5),''.join(rng.choice('01ABCDEF') for _ in range(14))) for x in range(12,W,24)]
base=Image.new('RGB',(W,H),(5,13,14));d=ImageDraw.Draw(base)
for x in range(0,W,40):d.line((x,0,x,H),fill=(9,24,24))
for y in range(0,H,40):d.line((0,y,W,y),fill=(9,24,24))
for y in range(H):
 glow=max(0,1-abs(y-190)/230)
 d.line((0,y,740,y),fill=(5,int(13+8*glow),int(14+5*glow)))
d.rounded_rectangle((1,1,W-2,H-2),radius=20,outline=(31,72,61),width=2)
d.line((40,36,96,36),fill=green,width=4)
d.text((110,24),'ROMARIO-ANCHAISE / RESEARCH LAB',font=small,fill=muted)
d.rounded_rectangle((1066,19,1158,53),radius=9,fill=(12,39,29),outline=(38,111,77))
d.text((1086,25),'V3.0',font=tagfont,fill=green)
d.text((42,87),'CYBERSECURITY',font=title,fill=white)
d.text((42,146),'ANDROID',font=title,fill=green)
d.text((45,221),'INGENIERÍA INVERSA',font=sub,fill=(174,209,193))
x=45
for label in ['REA','JADX','GHIDRA']:
 width=int(d.textlength(label,font=tagfont))+30
 d.rounded_rectangle((x,277,x+width,312),radius=7,outline=(39,91,70),fill=(8,29,25))
 d.text((x+15,284),label,font=tagfont,fill=(153,224,187));x+=width+12
d.line((43,343,1157,343),fill=(29,60,50),width=1)
d.text((44,363),'ESTUDIO DE MALWARE  /  ANÁLISIS ESTÁTICO',font=small,fill=muted)
d.text((825,363),'CÓDIGO + EVIDENCIA',font=small,fill=(95,174,137))
frames=[]
lines=['sample: CosaRara','target: Android APK','mode: static analysis','evidence: preserved']
for k in range(84):
 im=base.copy();draw=ImageDraw.Draw(im)
 # Sparse code rain lives only on the right, behind the terminal.
 for x,start,speed,text in columns:
  if x<766:continue
  head=(start+int(k*speed*5))%440
  for i,ch in enumerate(text):
   y=head-i*18
   if 61<y<332:draw.text((x,y),ch,font=small,fill=(12,29+max(0,14-i),24))
 draw.rounded_rectangle((764,78,1158,325),radius=13,fill=(5,15,15),outline=(37,98,72),width=2)
 draw.rounded_rectangle((765,79,1157,115),radius=12,fill=(12,32,27))
 draw.rectangle((766,101,1156,115),fill=(12,32,27))
 for xx,col in [(784,(88,135,111)),(802,(48,93,72)),(820,(33,67,53))]:draw.ellipse((xx,92,xx+7,99),fill=col)
 draw.text((849,87),'analysis / read-only',font=small,fill=(142,178,158))
 t=k/12
 shown=int(max(0,t-.4)*24)
 offset=0
 for j,line in enumerate(lines):
  count=max(0,min(len(line),shown-offset));offset+=len(line)+5
  draw.text((786,137+j*37),'>',font=mono,fill=green)
  draw.text((810,137+j*37),line[:count],font=mono,fill=(180,220,198))
  if 0<=shown-(offset-len(line)-5)<=len(line) and k%12<7:
   pos=810+int(draw.textlength(line[:count],font=mono));draw.rectangle((pos,140+j*37,pos+9,158+j*37),fill=green)
 # Thin slow scan, deliberately low contrast and without flashing.
 scanx=772+(k*5)%376
 draw.line((scanx,318,min(scanx+38,1148),318),fill=(55,145,100),width=2)
 draw.ellipse((713,36,719,42),fill=(59,int(170+22*math.sin(k/84*2*math.pi)),109))
 frames.append(im)
palette=frames[-1].quantize(colors=96,method=Image.Quantize.MEDIANCUT)
indexed=[f.quantize(palette=palette,dither=Image.Dither.NONE) for f in frames]
indexed[0].save(OUT/'cyber-lab-banner.gif',save_all=True,append_images=indexed[1:],duration=85,loop=0,optimize=True,disposal=1)
frames[-1].save(OUT/'cyber-lab-banner-static.png',optimize=True)
print('Rendered',OUT/'cyber-lab-banner.gif',(OUT/'cyber-lab-banner.gif').stat().st_size,'bytes')
