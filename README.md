# ZEPETO-Android
ZEPETO 담당 안드 MBTI 검사하면 CUTE 나온다며?

## Github 컨벤션

### commit

![commit convention](https://user-images.githubusercontent.com/48896148/169574819-32389eff-c235-4d0e-bcc6-d823240980fe.png)
<13조의 커밋 내역>

커밋 메시지의 경우 제목, 본문, 꼬리말 등 명료한 내용부터 구체적인 내용 순으로 적는것이 일반적입니다.
우리 13조 ZEPETO-Android 에서는 대괄호 안에 태그를 적고 따로 구분 선 없이 작업 내용에 대해 간략하게 서술 하기로 하였습니다.
이 때 대괄호 안에 적는 태그는 대문자로 통일 하여 가독성을 높였습니다.

장기간의 대규모 프로젝트를 진행하기 위해서는 짜임세 있는 커밋 컨벤션이 요구됩니다. 하지만 이번 합동 세미나의 경우 여러 방면으로 학습 하는 과정이기 떄문에
구체적인 커밋 메시지를 보다 명료하고 가독성이 좋게 쓰기로 협의했습니다.

### Pull Request

![commit convention](https://user-images.githubusercontent.com/48896148/169577358-e20a3a00-d67e-4171-b21d-e54e3fffd4c4.png)
<설희의 PR 캡쳐> 팟장님도 리뷰를 해 주셨네요 최고최고!!

본인의 작업 량이 어느정도 진행 되거나, 끝나게 되어 main 혹은 작업이 끝난 branch 로 merge or pull 하기 전에 Pull Request를 올리고 13조의 contributors 는 이를 확인하여 approve 하기로 했습니다.

모두 approve 하면 PR을 마치고 merge 합니다.

## 코드 컨벤션

![code_convention](https://user-images.githubusercontent.com/48896148/169579226-91dd263a-11fe-4152-83a2-80b418d330e2.png) ![code_convention2](https://user-images.githubusercontent.com/48896148/169579242-102c72c1-bcb4-420d-8a3a-4351a8cab12a.png)
<Project 내부 파일들의 이름, 객체에 id를 설정한 경우 id 의 모습>

13조의 code convention 은 기본적인 프로그래밍 언어들의 규칙을 따릅니다. 특히 developer.android.com 에 서술 되어 있는 kotlin style guide를 따릅니다.
파일, 클래스, 객체 id 의 경우 파일(객체)의 종류와 용도에 맞는 이름을 camelCase 와 snake_case 중 적합한 case로 작성합니다.

## 폴더 구조

![pakaging](https://user-images.githubusercontent.com/48896148/169580711-e7b9d56e-afcf-4139-afae-fb00056707e8.png)
<같은 층에 ui(pakage), util 존재 ui의 내부에 main 존재>

언급한 부분 이외에는 기본적인 폴더 구조를 유지합니다.

13조에서는 ui 와 util, 즉 기능을 기준으로 pakage를 나누었습니다. ui 에서는 application 의 view들의 구성에 따라 같은 깊이에 있는 파일들 끼리
묶어주었습니다. 독립적인 activity 3개는 같은 깊이에 있고, MainActivity 내에 존재하는 5개의 fragment 한 폴더 더 깊은 곳에 있습니다.


## 브랜치 전략

대규모 프로젝트에서 자주 쓰이는 여러 브랜치 전략들에 대해 첫 모임때 공부했습니다. git-flow, github-flow, ...
조원 각자의 이름으로 branch를 파서 작업 후 , main 브랜치에 merge 하며 협업을 진행했습니다.
이 때 merge from main to 'someone branch' and merge to main 방식으로 git을 관리했습니다.

merge from main to 'someone branch' 방식이란? 13조에서 한 방식을 일컫는 말...
