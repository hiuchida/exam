# 初期画面設定

ここでは、infoScoop OpenSourceに初めてユーザーがログインした際に表示する画面構成の設定方法について説明します。


# 1 初期画面設定

infoScoop OpenSourceは、ユーザーがガジェットの状態や配置を自由にカスタマイズすることができ、各ユーザーの画面の状態はデータベースに自動的に保存されます。

ユーザーが再度infoScoop OpenSourceの画面を表示すると、データベースに保存されているカスタマイズ情報を元にユーザー用の画面を構築します。

ユーザーが最初にinfoScoop OpenSourceを表示した際には、ユーザーのカスタマイズ情報はありませんので、共通のデフォルト設定を用意しておく必要があります。

ここでは、ユーザーが最初にinfoScoop OpenSourceを表示した際の画面構成の設定方法について説明します。

また、初期画面は、ユーザーの所属情報に応じて初期画面を切り替えることもできます。

infoScoop OpenSourceは、ユーザーの所属情報を、HTTPヘッダから受け取ります。

初期画面設定管理では、以下の箇所が設定対象となります。

1. コマンドバー
2. 各タブ - 固定エリア
3. 各タブ - パーソナライズエリア


## 2 初期画面管理画面

ここからは、初期画面の設定方法について、主に管理画面の初期画面管理の操作方法について説明します。

[__レイアウト__]を選択し、[__初期画面__]を選択すると、初期画面を設定するための画面が表示されます。

設定対象はタブで表されており、[__commandbar__]はコマンドバー、[__tab0__][__tab1__]...[__tabn__]は左から順にタブ設定を含みます。

各タブ内には、ロール一覧が表示されます。

初期画面設定は、ロール(ユーザーの所属情報)に対して設定します。

すべてのユーザーが同じ初期画面を利用する場合は「defaultRole」のみ使用します。

設定対象のロールの行にある編集アイコンをクリックすると、編集画面が表示されます。

管理画面より設定されるタブは全て固定タブとなります。

初期画面の編集画面はコマンドバーとタブで異なります。

* コマンドバー  
  コマンドバーの編集画面は以下の項目より構成されています。
    * ロール名
    * 主体者
    * 正規表現
    * 固定エリア設定: コマンドバー上に配置可能なコンポーネントの一覧を表示

* 各タブ  
  各タブの編集画面は以下の項目より構成されています。  
  コマンドバーと異なり、編集画面は別ウィンドウで開きます。
    * ロール名
    * 主体者
    * 正規表現
    * タブ名
    * 表示エリア
    * 固定エリア設定: レイアウト固定のガジェットを設定
    * パーソナライズエリア初期表示ガジェット設定: 初期表示時に配置されるガジェットの一覧を表示

タブの編集画面では、固定エリアと初期表示時に配置されるパーソナライズエリアの編集が可能です。


## 3 コンテキストメニュー

初期画面管理画面のコンテキストメニューについて説明します。

<table>
    <thead>
        <tr>
            <th>アイコン</th><th>名前</th><th>説明</th>
        </tr>
    </thead>
    <tbody<
        <tr>
            <td><img src="../../images/database_refresh.gif" alt="初期化アイコン"></td>
            <td>カスタマイズ情報を初期化</td>
            <td>
                指定したユーザーのカスタマイズ情報をすべて強制的に消去します。(参照: <a href="#initialize_customize">9 カスタマイズ情報の初期化</a>)
            </td>
        </tr>
        <tr>
            <td><img src="../../images/apply_changes.gif" alt="変更を適用するアイコン"></td>
            <td>変更を適用する</td>
            <td>
                クリックすると今までに行った編集操作(タブの追加/削除、ロールの追加/編集/削除/移動、コマンドバーの設定、タブの設定)を適用(データを保存)します。<br>
                <strong>注意</strong> 最終的にこのアイコンをクリックしないと、編集操作は破棄されます。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/preview.gif" alt="全体プレビューアイコン"></td>
            <td>全体プレビュー</td>
            <td>
                現在適用されている構成情報を別ウィンドウで表示します。<br>
                このアイコンは権限「メニュー」を持っている管理者ユーザーのみ利用可能です。
            </td>
        </tr>
    </tbody>
</table>


## 4 ロールの追加/編集/削除

初期表示画面の構成は、ユーザーのロール(所属情報)に従って切り替えることが可能です。

よって、初期画面は、各ロールに対して設定をします。

初期画面をロール毎に切り替える必要がなく、全てのユーザーの初期画面を同じに設定する場合は、「defaultRole」の編集画面を開き、<a href="#command_bar">5 コマンドバーの構成</a>以降を読み進めてください。

以下は、ロール一覧画面の構成及び操作方法についての説明です。

* ロール一覧: 初期画面は、ロール毎に設定します。  
  初めは、defaultRoleのみ用意されています。  
  infoScoopの利用者に単一の初期画面を用意する場合は、defaultRoleに設定します。
    * [__ロール名__]: ロールの表示用のラベルです。
    * [__主体者__]: ロールの種類を選択します。
    * [__正規表現__]: ロール判定は正規表現によって行われます。
  ロール名/主体者/正規表現、それぞれ適切な値を入力します。ロール名/正規表現はクリックで編集可能になります。

* 操作アイコン
    * 追加アイコン: ロール一覧に新しい設定を追加します。
    * 編集アイコン: 該当ロールの初期画面編集画面を表示します。
    * 削除アイコン: 該当ロールを削除します。defaultRoleは削除できません。
    * 並べ替え: ドラッグ&ドロップで順番を入れ替えます。

ユーザーの所属情報に対する正規表現の判定は上から順に行われます。

以下に、ロールに関する設定について説明します。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>ロール名</td>
            <td>
                この権限の名称を指定します。<br>
                ロール名はただのラベルでシステム的な意味はありません。対応する組織名称などを指定してください。
            </td>
        </tr>
        <tr>
            <td>主体者</td>
            <td>
                ロールの種類を選択します。<br>
                主体者は設定によりHTTPヘッダの値にマッピングされます。設定方法は、インストールガイドの <a href="customizing-web-application-module.md#http-header">5 HTTPヘッダをロール情報として定義する</a>を参照ください。
            </td>
        </tr>
        <tr>
            <td>正規表現</td>
            <td>
                この設定を使用する権限のパターンを正規表現で指定します。<br>
                ログイン時の権限がこのパターンにマッチした場合に、該当のタブのレイアウトが初期画面として適用されます。<br>
                正規表現の判定は、主体者別に上から順に判定され最初にマッチした設定が適用されます。<br>
                <strong>注意</strong> 正規表現には、Javaで使用可能な正規表現を記述する必要があります。
            </td>
        </tr>
    </tbody>
</table>

[![Add icon]__追加__]ボタンをクリックすると、一覧に新しいロールが追加されます。

設定項目は、ロール一覧画面と同じです。

[**一覧へ戻る**]をクリックするとロール一覧画面へ戻ります。


### 4.1 デフォルトを使用しない

デフォルトロール「defaultRole」を無効にすることで、該当ロールを持つユーザーにのみタブを表示させることができます。

この設定は、コマンドバー、tab0(ホームタブ)以外で有効です。

タブ内でロール追加アイコンの右側に表示される[**デフォルトを使用しない**]にチェックを入れることで無効にすることができます。


<a name="command_bar"></a>
## 5 コマンドバーの構成

コマンドバー固定エリアの設定方法について説明します。

固定エリアの設定項目は以下の通りです。

* ティッカー
* ランキング
* 文字サイズ変更
* ごみ箱
* 全体設定
* 認証情報一覧
* 管理画面
* ログアウト
* 検索フォーム

固定エリアのコンポーネント一覧の順序は、ポータル画面で表示されるコマンドバーでの表示順序に対応しています。

上記の各項目ごとに[並替]と[表示/非表示]オプションがついています。

* [__並替__]: 各項目左側に表示される[![Drag icon]並び替え]アイコンをドラッグ&ドロップすることによって順番を入れ替えることができます。

* [__表示/非表示__]: ユーザーメニュー内に表示するか、コマンドバー上に表示するか、非表示にするかをクリックで設定できます。
    * [__表示__]: ユーザーメニュー内に表示されます。ティッカーと検索フォームはユーザーメニュー内に表示できません。
    * [メニュー外に表示]: コマンドバー上に表示されます。ティッカーと検索フォーム、追加したリンクとHTML以外はアイコンのみが表示されます。
    * [__非表示__]: ユーザーメニューにもコマンドバーにも表示されません。  
      全てのコンポーネントが非表示に設定された場合、コマンドバー自体が表示されません。

* [__編集__]: ティッカーとランキング、追加したリンクとHTMLにのみ編集アイコンが表示されます。別途設定が必要です。
    * ティッカー: 電光掲示板ガジェット。ティッカーの項目の編集アイコンをクリックすると、RSSフィードのURLを編集するダイアログが表示されます。
    * ランキング: ランキングガジェット項目の編集アイコンをクリックするとランキングに表示するURLリスト(XML形式)を編集するダイアログが表示されます。設定内容は以下の表の通りです。
    * リンクとHTMLについては、<a href="#5_2_add_link_html">5.2 リンク追加/HTML追加</a>を参照してください。

* [__削除__]: 追加したリンクとHTMLにのみ削除アイコンが表示されます。アイコンをクリックして追加したリンクとHTMLを削除できます。

以下はランキングの設定項目についての説明です。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <strong>urls要素</strong>
            </td>
            <td>url要素を含みます</td>
        </tr>
        <tr>
            <td>
                <strong>url要素</strong>
            </td>
            <td>ランキング情報を設定します。</td>
        </tr>
        <tr>
            <td>title属性</td>
            <td>
                ランキングのタイトル。<br>
                ランキングガジェットのタブのタイトルになります。
            </td>
        </tr>
        <tr>
            <td>url属性</td>
            <td>ランキング情報をフィードするRSSのURLを設定します。</td>
        </tr>
    </tbody>
</table>


### 5.1 検索キーワードランキングのURLについて

ランキングはキーワードランキング生成サービスのURL(http://localhost:8080/infoscoop/kwdsrv)が指定されています。

```
http://localhost:8080/infoscoop/kwdsrv
```

URLパラメータを指定することにより、生成されるランキングをカスタマイズすることができます。  
サービスURLの___太字斜体___の箇所を編集します。

キーワードランキング生成URL

<pre><code>
&#60;urls&#62;
    &#60;url title='検索キーワードランキング'
            url='http://localhost:8080/infoscoop/kwdsrv?baseDate=<strong><i>TODAY</i></strong>&period=<strong><i>30</i></strong>&rankingNum=<strong><i>20</i></strong>/&#62;
&#60;/urls&#62;
</code></pre>

各パラメータの設定について以下に説明します。

<table>
    <thead>
        <tr>
            <th>パラメータ名</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td colspan="2">
                <strong>baseDate</strong>
            </td>
        </tr>
        <tr>
            <td>設定内容</td>
            <td>
                検索キーワードランキング作成の集計開始日時を指定します。<br>
                <strong>指定した集計開始日時から過去に向かってPERIODで指定した期間の検索キーワードランキングデータが作成されます。</strong>
            </td>
        </tr>
        <tr>
            <td>詳細</td>
            <td>
                TODAY: ツール実行日の0時を集計開始日時とします。TODAYを設定した場合、ランキングデータはサーバーにキャッシュされ、集計は1日に一度だけ行われます。通常はTODAYを設定してください。<br>
                yyyyMMddHH: 左記の日付フォーマットで指定した日時を集計開始日時とします。
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <strong>period</strong>
            </td>
        </tr>
        <tr>
            <td>設定内容</td>
            <td>
                検索キーワードランキング作成の期間(日数)を指定します。<br>
                BASE_DATEで指定した日時から指定した期間の検索キーワードランキングデータが作成されます。<br>
                最大値は60です。
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <strong>rankingNum</strong>
            </td>
        </tr>
        <tr>
            <td>設定内容</td>
            <td>
                ランキングデータの表示数を指定します。<br>
                生成後のデータが表示数に見たない場合は全て生成されます。<br>
                最大値は30です。
            </td>
        </tr>
    </tbody>
</table>


<a name="5_2_add_link_html"></a>
### 5.2 リンク追加/HTML追加

* リンク追加
  [![Add icon]__リンク追加__]をクリックすると設定画面が表示され、コマンドバーにリンクを追加することができます。  
  各設定内容は以下の通りです。

  <table>
      <thead>
          <tr>
              <th>設定項目</th><th>説明</th>
          </tr>
      </thead>
      <tbody>
          <tr>
              <td>表示名称</td>
              <td>リンクの表示名</td>
          </tr>
          <tr>
              <td>リンクURL</td>
              <td>リンクのURL</td>
          </tr>
          <tr>
              <td>リンク表示先</td>
              <td>
                  リンクのターゲットを指定します。
                  <ul>
                      <li>新しいウィンドウ: 新しいウィンドウにリンク先を表示します。</li>
                      <li>ポータル内フレーム: ポータル内フレームにリンク先を表示します。</li>
                  </ul>
              </td>
          </tr>
      </tbody>
  </table>

  [__追加__]ボタンをクリックすると一覧に追加されます。追加されたリンクは表示/非表示の切り替えはできません。

* HTML追加

  [![Add icon]__HTML追加__]をクリックすると以下の設定画面が表示され、コマンドバーにHTMLを追加することができます。
  各設定内容は以下の通りです。

  <table>
      <thead>
          <tr>
              <th>設定項目</th><th>説明</th>
          </tr>
      </thead>
      <tbody>
          <tr>
              <td>表示名称</td>
              <td>一覧に表示される名前です。</td>
          </tr>
          <tr>
              <td>HTML</td>
              <td>コマンドバーに表示するHTMLを記述します。</td>
          </tr>
      </tbody>
  </table>


## 6 タブの追加/削除

固定タブは、複数設定可能です。


<a name="tab_add"></a>
### 6.1 タブの追加

タブを追加するには、[![Add icon]__タブを追加__]ボタンをクリックします。


<a name="tab_delete"></a>
### 6.2 タブの削除

タブを削除するには、各タブの[閉じる]アイコンをクリックします。  
確認ダイアログが表示されますので[__OK__]をクリックしてください。


<a name="tab_layout"></a>
## 7 タブの構成

各タブの設定は、タブ名、固定エリアおよびパーソナライズエリアの初期表示の設定があります。

各設定項目については、以下の項で詳しく説明します。

**注意** タブ設定画面は別ウィンドウで表示されますが、編集内容を保存するためには、ロール追加やタブの追加/削除などと同様に、親ウィンドウの[__変更を適用する__]をクリックする必要があります。


### 7.1 タブ名

タブの名前を指定します。  
タブ名は最大80文字まで指定可能です。


### 7.2 固定エリア設定

[__レイアウト選択__]ボタンと[__HTML編集__]ボタンの下に、固定エリアに設定したいガジェットを設定するボックスが表示されます。

* レイアウト設定
  固定エリアのレイアウトの変更は、テンプレートから選択する方法とHTMLを直接記述する方法があります。  
  テンプレートからレイアウトを選択する場合は[__レイアウト選択__]ボタンをクリックします。すると、レイアウト選択画面が表示されます。  
  レイアウトにマウスを重ねるとレイアウトが反転します。反転した状態でクリックするとそのレイアウトが適用されます。

  **注意** レイアウトを変更すると、現在の設定を上書きし全てのガジェットが未設定になります。

  HTMLを直接編集する場合は、[__HTML編集__]ボタンをクリックします。

* ガジェット設定
  固定エリアの各ボックスにマウスを重ねると、[__EDIT__]\(初期設定の場合は[__NEW__])が表示されます。  
  その状態でボックスをクリックすると、ガジェット設定用のダイアログが表示されます。  
  固定エリアには以下のガジェットが設定可能です。

    * RSSリーダー
    * お知らせ
    * 画像つきお知らせ
    * ミニブラウザ
    * 切り取りミニブラウザ
    * イベントカレンダー
    * メッセージ
    * 人気ガジェット
    * ガジェット(ガジェット一覧に表示されているガジェット)
    * ガジェット(URL指定)

  [__ガジェットの種類__]を選択すると、選択したガジェットに応じた設定項目が表示されます。  
  各設定項目の必須項目を入力後[__プレビュー__]ボタンをクリックすることで、設定した内容のガジェットのプレビューが表示されます。


#### 7.2.1 ガジェットヘッダ設定

以下に、初期画面設定で選択可能なガジェットに共通の設定項目について説明します。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>タイトル</td>
            <td>
                ガジェットのタイトル。必須。<br>
                タイトルは、最大80文字まで入力可能です。
            </td>
        </tr>
        <tr>
            <td>タイトルリンク</td>
            <td>
                ガジェットのタイトルに付けられるリンクのURL。<br>
                URLは、最大1024バイトまで入力可能です。
            </td>
        </tr>
    </tbody>
</table>


#### 7.2.2 ガジェット設定(共通)

すべてのガジェットに共通の設定について説明します。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>ヘッダを表示しない</td>
            <td>
                有効にした場合、ガジェットのヘッダが表示されません。<br>
                固定エリアでのみ選択可能な項目です。
            </td>
        </tr>
    </tbody>
</table>


#### 7.2.3 ガジェットの情報をタイトルに設定する

RSSリーダーやミニブラウザは、指定されたURLから情報を取得して表示しますが、このようなガジェットを選択するとURLを指定するテキストボックスの右側に[__タイトル情報取得__]ボタンが表示されます。

[__タイトル情報取得__]ボタンをクリックすると、指定されたURLより取得した情報からタイトルとタイトルリンクを設定します。

TODOリストやアラームのように外部から情報を取得しないガジェット、または、カレンダーガジェットのようにガジェットとURLが一対一で指定されないガジェットの場合は、ガジェットのタイトルをメニュー項目のタイトルとして設定する[__タイトル情報に設定__]ボタンが表示されます。

[__タイトル情報に設定__]ボタンをクリックするとタイトルにガジェットの種類が入力されます。


#### 7.2.4 プレビュー

各設定項目の必須項目を入力後[__プレビュー__]ボタンをクリックすることで、設定した内容のガジェットのプレビューが表示されます。


#### 7.2.5 デフォルト値に戻す

ガジェット設定項目の下部には、[デフォルト値に戻す]ボタンが表示されます。各設定項目を、デフォルト値に戻します。デフォルト値はガジェット管理で設定された値が使用されます。


#### 7.2.6 ガジェットURL指定

HTTPサーバー上に配置されているガジェットは、直接URLをメニューに設定することができます。  
[__ガジェットの種類__]で「ガジェット(URL指定)」を選択すると、以下の設定項目が表示されます。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>ガジェットファイルURL</td>
            <td>
                ガジェットファイルのURLを指定します。<br>
                URLは、最大<strong>1022</strong>バイトまで入力可能です。<br>
                [<strong>タイトル情報取得</strong>]ボタンをクリックすると、指定したURLのガジェットファイルからタイトルとリンクを取得して、メニューリンク設定の[<strong>タイトル</strong>]と[<strong>タイトルリンク</strong>]にセットします。
            </td>
        </tr>
    </tbody>
</table>


### 7.3 パーソナライズエリア初期表示ガジェット設定

パーソナライズエリア初期表示ガジェット設定では、ユーザーが初期ログイン時にデフォルトで配置されるガジェットを設定することができます。

パーソナライズエリアに配置するガジェット設定は、ポータル画面にメニュー/サイドメニューからドラッグ&ドロップで配置します。

![Gadget placement by drag-and-drop operation]

上記のように配置した場合、初期ログイン時のパーソナライズエリアでは以下のようにガジェットが配置されます。

![The personailzed area of first login]


#### 7.3.1 ガジェットの削除

配置されたガジェットを設定するには、各ガジェットヘッダの[X]アイコンをクリックします。


#### 7.3.2 列数の設定

初期表示の列数は、パーソナライズ領域内の[列]コンボボックスで設定することができます。


#### 7.3.3 トップメニュー/サイドメニューの表示内容について

タブ設定画面で表示されるトップメニュー/サイドメニューの内容は、以下のルールで表示されます。

* 公開/非公開の設定にかかわらず、全てのメニューアイテムが表示されます。
    * 参照権限を持たないユーザーが該当のガジェットを参照した場合、利用不能なガジェットとして表示されます。
* 外部サービスURLが指定されているメニューツリーは表示されません(初期配置できません)。


#### 7.3.4 複数ドロップできないガジェットに関する規則

複数ドロップできないガジェットの重複チェックはタブ内でのみ行われます。タブをまたがるチェックは行っていないため初期画面設定のパーソナライズエリア設定では、複数ドロップできないようメニューで設定されているガジェットも別のタブであれば複数箇所に設定可能となっています。

しかし、ガジェットが重複して設定された場合、ユーザー初期ログイン時の画面構成において前方のタブに設定されたガジェットが削除されます。

例えば、タブ1とタブ2に、同じメニュー設定からRSSリーダーを配置した場合、ユーザーが初めてログインしたときにタブ2のRSSリーダーのみ有効となり、タブ1のRSSリーダーは配置されません。


#### 7.3.5 設定したガジェットがメニュー設定から削除された場合

パーソナライズエリアに設定したガジェットの定義が該当するメニューから削除された場合やメニューそのものが削除された場合、そのガジェットは利用不能なガジェットとして表示されます。利用不能なガジェットは削除可能です。


#### 7.3.6 表示エリアの設定

[__表示エリア__]ドロップダウンリストを設定することで、タブ内に表示されるエリアを指定することができます。

「固定エリアとパーソナライズエリアをどちらも表示する」に設定した場合、タブ内に固定エリアとパーソナライズエリア両方を表示します。
「パーソナライズエリアを使用しない」に設定した場合、固定エリアのみを表示します。

「固定エリアの高さをブラウザの高さにあわせて表示する」に設定した場合、固定エリアに配置されたガジェットの高さを、ヘッダ部を除いたウィンドウの高さに調整して表示します。


## 8 ユーザー画面への適用について

初期画面設定の変更がユーザー画面に適用されるルールは、初期ログイン時とユーザーが既にログイン済であるかによって異なります。


### 8.1 初期ログイン時

ユーザーがinfoScoop OpenSourceを初めて表示した場合は、初期画面設定に設定によって画面が構成されます。


### 8.2 既ログインユーザー

初期画面設定の変更は、ユーザーがブラウザを再ロードした際に反映されます。  
反映ルールは、変更箇所ごとに以下のルールで適用されます。


#### 8.2.1 コマンドバーの構成変更

<a href="#command_bar">5 コマンドバーの構成</a>の手順によってタブの構成を変更した後、ユーザーがブラウザを再ロードした際、ユーザー画面のコマンドバーが上書き更新されます。


#### 8.2.2 タブの追加

<a href="#tab_add">6.1 タブの追加</a>の手順で固定タブを追加した場合、ユーザーの画面には、ユーザーがブラウザを再ロードした際に、追加した固定タブは固定タブと動的タブ(ユーザーが追加したタブ)の間に追加されます。

__例__: ユーザー画面のタブ構成が以下のような場合


```
[固定タブ1][動的タブ1][動的タブ2]
```

固定タブ[固定タブ2]を追加すると、ブラウザ際読み込み後ユーザー画面のタブ構成は自動的に以下のように変更されます。

<pre><code>
[固定タブ1]<strong>[固定タブ2]</strong>[動的タブ1][動的タブ2]
</code></pre>


#### 8.2.3 タブの削除

<a href="#tab_delete">6.2 タブの削除</a>の手順で固定タブを削除した場合、ユーザーの画面では固定タブは削除されず、削除された固定タブは固定エリアのなくなった動的タブ(ユーザーが追加したタブ)になります。また、動的タブに変更されたタブはもっとも右側に自動的に移動します。

__例__: ユーザー画面のタブ構成が以下のような場合

<pre><code>
[固定タブ1]<strong>[固定タブ2]</strong>[動的タブ1][動的タブ2]
</code></pre>

固定タブ[固定タブ2]を削除すると、ブラウザ際読み込み後ユーザー画面のタブ構成は自動的に以下のように変更されます。

<pre><code>
[固定タブ1][動的タブ1][動的タブ2]<strong>[動的タブに変更された固定タブ2]</strong>
</code></pre>


#### 8.2.3 タブの構成変更

<a href="#tab_layout">7 タブの構成</a>の手順によってタブの構成を変更した後、ユーザーがブラウザを再ロードした際、以下の規則でユーザー画面に反映されます。

* 固定エリアのレイアウトを変更した場合:  
  ユーザー画面の固定エリアはすべて管理者設定で上書きされます。更新されたガジェットのユーザー設定は初期値に戻ります。

* 固定エリア設定のガジェット設定を変更した場合:  
  設定を変更したガジェットのみ、管理者設定で上書きされます。更新されたガジェットのユーザー設定は初期値に戻ります。

* パーソナライズエリアのガジェット設定を変更した場合:  
  パーソナライズエリアのガジェットの配置情報は、初期ログイン時のみ有効でinfoScoop OpenSourceを再読み込みしても反映されません。


<a name="initialize_customize"></a>
## 9 カスタマイズ情報の初期化

カスタマイズ情報の初期化は指定したユーザーのカスタマイズ情報(ユーザーにより設置されたガジェット、追加されたタブ、全体設定)を削除し、初期画面設定の設定によって画面を構成します。

**注意** カスタマイズ情報の初期化で削除されたガジェットはゴミ箱に入ります。

カスタマイズ情報の初期化を行うには、初期画面管理画面の[__カスタマイズ情報を初期化__]リンクをクリックします。

カスタマイズ情報初期化ダイアログが表示されます。

ユーザー名入力フィールドにカスタマイズ情報を初期化するユーザー名を入力し［__OK__］ボタンを押してください。指定したユーザーのカスタマイズ情報が初期化されます。

指定したユーザーがポータル画面を表示中の場合は、強制的にブラウザのリロードが行われます。


[Add icon]: ../../images/add_menu_tree.gif "追加"
[Drag icon]: ../../images/drag.gif "並べ替え"
[Gadget placement by drag-and-drop operation]: images/default-screen/default-layout-settings-1.png "図1 ドラッグ&ドロップによる配置イメージ"
[The personailzed area of first login]: images/default-screen/default-layout-settings-2.png "図2 初期ログイン時のパーソナライズエリア"