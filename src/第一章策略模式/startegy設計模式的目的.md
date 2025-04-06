# Startegy design patten 目的
組合模式的擴展（行為委託）
將各種行為都設計為可插拔的組件：

## 問題： 
Q:
今天系統有一個Duck的abstract class, Duck裡面有swim,quack,fly,display四個方法
- swim是個void,固定每個繼承Duck都能游泳,
- quack是叫的方法,繼承Duck的物件可以Override quack()方法,讓他們有各自的叫聲,但不一定每個鴨都一定要有叫聲
- fly是飛的方法,繼承Duck的物件可以Override fly()的方法,讓他們有各種飛的方法,但不一定每個鴨子都一定會飛
- display是abstract的方法,每個繼承Duck "必須"實作這個方法,因為每個鴨都要介紹自己是什麼鴨

#### Q1: 這樣的設計有什麼問題？
#### A : 
假如現在是有30個子物件繼承Duck,個別Override他們的fly跟quack,去做各自的quack跟fly 
但假設有一天PM説我要再加另外40個子物件,但這些各種Duck沒有fly的方法,因為他們都是塑料跟木製的鴨子？  
怎麼辦？
新增的子物件你都Override fly()方法把它變成空實例? --> 不是好的設計

#### Q2 : 新增的子物件你都Override fly()方法把它變成空實例,這樣不好的原因
#### A:
當子class extends 父class時,當子class完全用不到fly() 方法  
此時違反了
1. 「空實現的問題」: 因為fly你必須Override後,裡面不實作任何方法
2. 「違反介面隔離原則」：一個類不應該被強制依賴它不使用的方法

#### Q3 : 如何改善這個問題?
#### A:  
為了避免未來有quack跟fly都有可能會有鴨子實現不了,我們可以把quack跟fly抽離出來特別封裝起來
1. 把Fly這個變成一個Interface ex : interface FlyBehavior
2. 把Quack變成一個Interface  ex : interface QuackBehavior
3. 把各種XXXFly方法去implement FlyBehavior , XXXQuack implement QuackBehavior
4. 在Duck裡面去宣告兩個 Flybehavior flybehavior , QuackBehavior quackBehavior, 讓子元件去可以改寫這兩個behavior
5. 在Duck去加performQuack方法跟performFly方法,然後用呼叫interface的方法(這樣就是動態)
6. 在子Duck類別也不用再寫fly方法或quack方法,只需要設定要用哪一個flyBehavior跟quackBehavior
7. 最後在Duck裡面設定setFlyBehavior,setQuackBehavior,能更彈性的讓子物件去換行為
