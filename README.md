## MVP-Example
- 안드로이드 MVP Pattern 를 이해하기 위한 샘플 프로그램입니다.
- 최대한 MVP Pattern을 이해하기 위한 소스만으로 작성하였습니다.
- 코틀린으로 작성되었습니다. 
![image](https://user-images.githubusercontent.com/72640840/110723517-892b1600-8257-11eb-886e-5a07cbf99ef5.png)
***
### 소스 설명
- Model, View, Presenter의 약자입니다.
- MVP패턴은 View와 Presenter 간 1:1 관계입니다.  
- 파일명을 [xxx]Activity.kt, [xxx]Presenter.kt, [xxxImpl].kt 라고 지어서 구분하기 쉽게 했습니다.
- 만약 소개하는 페이지를 만든다면, IntroActivity.kt, IntroPresenter.kt, IntroImpl.kt 라고 짓는 방법입니다.
- 본 소스에서는 MainActivity.kt, MainPresenter, MainImpl로 이름을 지었습니다.


### MainImpl.kt
```python
interface MainImpl {

    interface View {
        fun showSkillSet(mapSkilSet:Map<String, String>)
    }
    interface Presenter {
        fun updateSkillSet()
    }
}
```
- View와 Presenter가 구현할 interface를 준비해놓습니다.
- Activity가 MainImpl.View를 구현할 것입니다.  
- Presenter가 MainImpl.Presenter를 구현할 것입니다.  
- Impl이 아닌, Contract라는 단어도 사용 합니다. -> ex) MainContract.kt  

### MainActivity.kt  
```python
class MainActivity : AppCompatActivity(), MainImpl.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = MainPresenter(this)

        btn_update_skill_set.setOnClickListener {
            presenter.updateSkillSet()
        }
    }

    override fun showSkillSet(mapSkilSet: Map<String, String>) {
        var strSkillSet = ""
        for ((key, value) in mapSkilSet) {
            strSkillSet += "[${key}]\n${value}\n\n"
        }
        txt_skill_set.text = strSkillSet

    }
}
```
- Activiy는 View의 역할을 하기위해, View interface를 상속받아 UI로직을 구현합니다.  
- View interface에 Presenter가 호출할 UI변경 로직을 준비해놓습니다. ->showSkillSet()  
- 

### MainPresenter.kt

```python
class MainPresenter : MainImpl.Presenter {
    lateinit var view: MainImpl.View

    constructor(view: MainImpl.View) {
        this.view = view
    }

    override fun updateSkillSet() {
        val mapSkilSet:Map<String, String> = mutableMapOf(
                                    "Platform" to "Android, .NET",
                                    "Language" to "Kotlin, Java, C#, C++, Python",
                                    "SoftwareDesignPattern" to "MVP, MVC, MVVM",
                                    "Communication" to "HTTP, TCP/IP, RS232C, FTP")

        view.showSkillSet(mapSkilSet)
    }
}
```
- Presenter는 중간다리 역할로, View를 가지고 있고 적절한 타이밍에 view를 호출하여 UI를 변경합니다.  
- 위의 소스는 비즈니스로직이 끝나는 시점에 showSkillSet으로 View(Activity)를 갱신해주었습니다.


***

![image](https://user-images.githubusercontent.com/72640840/110723543-9516d800-8257-11eb-9fd1-bd8df166e81c.png)

