# メニュー管理

メニューの構成および各メニュー項目の設定方法について説明します。


## 1 メニュー

infoScoop OpenSourceは、内部サイトおよび外部サイトを階層化されたメニューとして管理します。  
メニューは、画面上部に表示されるトップメニューと、画面左側のタブに含まれるサイドメニューがあります。  
メニューには、リンク集としての役割とRSSリーダーをはじめ、各種ガジェットを選択するための機能があります。  
メニューの管理は、専用の管理画面があり、メニュー項目の追加、編集、削除、順番変更を行うことができます。  
また、メニューツリーに外部サービスを指定することができます。


## 2 メニュー管理画面

メニュー管理画面は、管理画面上部のメニューより[メニュー]をクリックして開きます。  
メニュー管理画面は、メニューの管理をエクスプローラ風の操作で行うことができます。


## 3 メニューの選択

infoScoop OpenSourceのメニューには、__トップメニュー__と__サイドメニュー__の2つの階層メニューがあります。  
メニュー管理画面左のサイドバーから参照/編集するメニューを選択することができます。  
トップメニューとサイドメニューの構成は、同じにするか異なる構成にするかを選択することができます。  
トップメニューとサイドメニューを同じ構成にするかどうかは「displaySideMenu」プロパティで指定します。

プロパティの設定方法については、[プロパティ管理][Properties Settings]を参照してください。  
トップメニューとサイドメニューを同じ構成にして、サイドメニューを選択した場合、「トップメニューと同じメニューURLを参照しています」というメッセージが表示されサイドメニューの編集は無効のまま表示されます。

## 4 コンテキストメニュー

メニュー管理画面のコンテキストメニューについて説明します。

<table>
    <thead>
        <tr>
            <th>アイコン</th><th>名前</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="../../images/open_all.gif" alt="全てのメニューを開くアイコン"></td>
            <td>全て展開</td>
            <td>
                メニューを全て表示します。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/close_all.gif" alt="全てのメニューを閉じるアイコン"></td>
            <td>全て閉じる</td>
            <td>
                メニューを全て閉じます。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/add_menu_tree.gif" alt="メニューツリー追加アイコン"></td>
            <td>メニューツリー追加・順番変更する</td>
            <td>
                クリックすると、トップメニューの順番変更、新しいメニューツリーの追加が可能になります。<br>
                このアイコンは権限「メニュー」を持っている管理者ユーザーのみ利用可能です。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/add_menu_tree.gif" alt="メニューツリー追加アイコン"></td>
            <td>メニューツリーを追加</td>
            <td>
                新しいメニューツリーを追加します。<br>
                クリックするとメニュー設定を行うダイアログが表示されます。<br>
                このアイコンはツリー追加/移動モードの場合にのみ利用可能です。<br>
                各設定内容は、<a href="#menu_item_add_change">7 メニュー項目の追加・変更</a>を参照ください。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/refresh.gif" alt="読み直しアイコン"></td>
            <td>読み直し</td>
            <td>
                前回変更を適用した状態を表示します。<br>
                展開していたメニューは閉じ、メニューツリーだけを表示します。
            </td>
        </tr>
        <tr>
            <td></img src="../../images/refresh.gif" alt="読み直しアイコン"></td>
            <td>全ロック解除</td>
            <td>
                全てのルートメニュー、順番変更のロックを解除し、前回変更を適用した状態を表示します。<br>
                展開していたメニューは閉じ、メニューツリーだけを表示します。<br>
                このアイコンはツリー編集モードの場合にのみ利用可能です。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/apply_changes.gif" alt="変更を適用するアイコン"></td>
            <td>変更を適用する</td>
            <td>
                クリックすると今までに行った編集操作(追加/編集/削除/移動)を適用(データを保存)します。<br>
                このアイコンはツリー編集モードの場合にのみ利用可能です。<br>
                <b>注意</b> 最終的にこのアイコンをクリックしないと、編集操作は破棄されます。
            </td>
        </tr>
        <tr>
            <td><img src="../../images/preview.gif" alt="プレビューアイコン"></td>
            <td>全体プレビュー</td>
            <td>
               現在適用されている構成情報を別ウィンドウで表示します。<br>
               このアイコンは権限「メニュー」を持っている管理者ユーザーのみ利用可能です。
            </td>
        </tr>
    </tbody>
</table>


## 5 編集モードとロックについて

メニュー管理は、複数のユーザーが同時に操作することを考慮されているため、各操作に対して、__参照モード__、__編集モード__、__ツリー追加/順番変更モード__が割り当てられています。  
編集モード、ツリー追加/順番変更モードは、それぞれ独立したロック機構を持ちます。


## 5.1 参照モード

メニュー管理画面表示時の初期状態です。  
ルートメニュータイトルを右クリックすると、以下のようなメニュー項目設定用のメニューが表示されます。

* [ロックして編集]: トップメニューのロックを取得し、メニューツリーを編集モードにします。
* [参照]: メニュー参照ダイアログを表示します。

「ロックして編集」クリック時、そのメニューツリーは編集モードに移行します。  
「ロックして編集」は、ルートメニューのみに表示されます。  
また、メニュー項目左の[+][-]アイコンをクリックすることによってメニューを開閉できます。


## 5.2 編集モード

参照モードのメニューツリーに対して「ロックして編集」操作を行うことにより、メニューツリーのロックを取得して編集モードに移行します。  
メニュータイトルを右クリックするとメニュー項目設定用のメニューが表示されます。

* [__編集__]: メニュー編集ダイアログを表示します。
* [__削除__]: メニュー削除ダイアログを表示します。
* [__追加__]: メニュー追加ダイアログを表示します。

ロック状態のメニューツリーのタイトル色は青色になります。
ロックはツリー単位で行われます。複数のツリーをロックすることも可能です。


## 5.3 ツリー追加/順番変更モード

コンテキストメニュー「メニューツリー追加・順番変更する」をクリックすることにより、ツリー追加/順番変更モードに移行します。  
ツリー追加/順番変更モードでは、メニューツリーの順番に関する情報のみがロックされます。  
ツリー追加/順番変更モードに移行後、コンテキストメニュー「メニューツリーを追加」をクリックすることにより、新規メニューツリーを追加することができます。  
またルートメニューをドラッグすることで、メニューツリーの順番変更ができます。


## 5.4 排他制御

編集モード、ツリー追加/移動モードでは、他ユーザーとの編集の衝突を防ぐため、ロックを取得してから編集を行います。  
他ユーザーによって編集中(ロック状態)であるメニューツリーに対して「ロックして編集」を行った場合、または他ユーザーがメニューツリー順番変更を行っている状態で「メニューツリー追加・順番変更する」を行った場合、他のユーザーが編集中であることを示すダイアログが表示されます。  
「処理を続行すると上記ユーザーの編集データは破棄されます」というメッセージに対して[OK]を選択すると、ダイアログに表示されているユーザーの編集データ(「変更を適用する」をクリックする前の状態)は破棄されます。編集データの破棄されたユーザーは、その後編集を行っても全てエラーとなります。

**注意** 強制的にロックを取得可能なのは管理権限メニューを含むロールを持つ管理者のみです。権限メニューを含まないロールが設定されている管理者はロックが解除されるまで編集はできません。

ロック状態は、編集中ユーザーが以下のオペレーションを行った際に解除されます。

* 全ロック解除を行ったとき
* 他の管理メニューを選択したとき
* 管理画面から他のURLへ移動したとき
* ブラウザを閉じたとき

また、ロックにはタイムアウトがあり、最後の編集操作から30分が経過すると全てのロックが解除されます。

**注意** タイムアウト時、「変更を適用する」を行っていない編集内容は全て失われます。

タイムアウト時間はプロパティ「menuLockTimeout」で編集可能です。  
プロパティの設定方法については、[プロパティ管理][Properties Settings]を参照してください。


## 6 メニュー項目の移動

メニュー、メニューツリーは、ドラッグ&ドロップでそれぞれ移動させることができます。


### 6.1 メニューの移動

この操作は編集モード時に可能です。  
横一直線の点線が表示される任意の場所で左クリックを放すとその位置に移動します。  
また、他のメニューの上に重ねるとそのメニューを囲むように点線が表示されます。点線が表示される任意の場所でドロップすると、重ねられた方のメニューの子メニューに移動します。


### 6.2 メニューツリーの移動

この操作はツリー追加/順番変更モード時に可能です。  
「メニューツリー追加・順番変更する」をクリックすることにより、メニューツリーの移動が可能になります。横一直線の点線が表示される任意の場所で左クリックを放すとその位置に移動します。  
メニューツリーは、追加移動を行うことはできません。


<a name="menu_item_add_change"></a>
## 7 メニュー項目の追加・変更

編集モード時、各メニューの右クリックメニューで[__追加__]を選択するとメニュー設定ダイアログが表示されます。  
設定項目は以下の通りです。

* メニューリンク/ガジェットヘッダ設定
* ガジェット設定
* 公開設定
* アラート設定

また、ツリー追加/順番変更モードの時、コンテキスト[__メニューツリーを追加__]をクリックするとメニューツリー用のメニュー設定ダイアログが表示されます。  
設定項目は以下の通りです。

* メニューリンク設定
* 管理者設定
* 公開設定
* アラート設定

以下は、各設定項目についての詳細です。


### 7.1 メニューリンク/ガジェットヘッダ設定

ここでは、メニュー項目のタイトルとタイトルに付けるリンクを設定します。メニューにガジェットを設定した場合、この設定は追加したガジェットのヘッダのタイトルに適用されます。

以下はメニューリンクについての説明です。

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
                メニューのタイトル。必須。<br>
                タイトルは、最大80文字まで入力可能です。
            </td>
        </tr>
        <tr>
            <td>タイトルリンク</td>
            <td>
                メニュータイトルに付けられるリンクのURL。<br>
                URLは、最大1024バイトまで入力可能です。
            </td>
        </tr>
        <tr>
            <td>リンク表示設定</td>
            <td>
                タイトルリンクの表示先を設定します。<br>
                [自動判定]: プロパティdisplayInlineHostの設定に従いポータル内フレームまたは新しいウィンドウが適用されます。(参照: 「displayInlineHost」)<br>
                [ポータル内フレーム]: ポータル内インナーフレームにリンク先を表示します。<br>
                [新しいウィンドウ]: リンク先を別ウィンドウで表示します。
            </td>
        </tr>
        <tr>
            <td>メニューにリンクを張らない</td>
            <td>
                ガジェット設定時にのみ有効。<br>
                メニューにはリンクを表示せず、設定されているガジェットが追加された場合にガジェットヘッダに設定されているタイトルリンクが張られる。
            </td>
        </tr>
        <tr>
            <td>外部サービスURL</td>
            <td>
                外部サーバーからメニュー設定を取得する場合のURL。<br>
                コンテキストメニューの[メニューツリーの追加]から表示したダイアログ、または外部サービスメニューが設定されているメニューツリーのルートのみ設定可能。<br>
                (参照: <a href="#specify_external_service">10 外部サービスを指定する</a>)
            </td>
        </tr>
        <tr>
            <td>外部サービス認証タイプ</td>
            <td>
                外部サービスURLを指定した場合に、ポータルのログインユーザーIDをサービスに渡す方法を指定できます。<br>
                <b>無し</b>: ログインユーザーの情報は送信されません。<br>
                <b>postPortalCredential</b>: ポータルにログインしているユーザーIDをRSS取得時にPOSTします。postPortalCredentialを選択すると、POSTデータに含めるユーザーIDのパラメータ名を指定するテキストボックスが表示されます。パラメータ名を指定しない場合、ユーザーIDのパラメータ名は「is-user」になります。<br>
                <b>sendPortalCredentialHeader</b>: ポータルにログインしているユーザーIDをRSS取得時にヘッダ送信します。sendPortalCredentailHeaderを選択すると、ユーザーIDを送信するヘッダ名を指定するテキストボックスが表示されます。パラメータ名を指定しない場合に、送信されるユーザーIDのヘッダ名は「is-user」です。
            </td>
        </tr>
    </tbody>
</table>


### 7.2 ガジェット設定

ここでは、メニュー項目に関連するガジェットを設定します。  
メニューに設定可能なガジェットは以下の通りです。

* イベントカレンダー
* RSSリーダー
* まとめてRSSリーダー
* ミニブラウザ
* 切取りミニブラウザ
* ガジェット(URL指定)
* TODOリスト
* アラーム
* 電卓
* 人気ガジェット
* メッセージ
* ブログパーツ
* 付箋
* 標準時時計
* ガジェット(ガジェット管理で追加したガジェット)

[**ガジェットの種類**]を選択すると、選択したガジェットに応じた設定項目が表示されます。  
設定可能な項目は、ガジェット仕様では/Module/UserPrefの初期値です。  
またこのダイアログでは、UserPref要素のdatatype属性値が「hidden」であるUserPrefの初期値も指定できます。

**注意** 一度ガジェットの種類を設定すると、変更することはできません。

各ガジェットの設定項目については各ガジェット設定の説明をご参照下さい。  
ここでは、メニュー設定ダイアログのみに表示される設定について説明します。


#### 7.2.1 ガジェットの情報をタイトルに設定する

RSSリーダーやミニブラウザは、指定されたURLから情報を取得して表示しますが、このようなガジェットを選択するとURLを指定するテキストボックスの右側に[__タイトル情報取得__]ボタンが表示されます。  
[タイトル情報取得]ボタンをクリックすると、指定されたURLより取得した情報からタイトルとタイトルリンクを設定します。  
TODOリストやアラームのように外部から情報を取得しないガジェット、または、カレンダーガジェットのようにガジェットとURLが一対一で指定されないガジェットの場合は、ガジェットのタイトルをメニュー項目のタイトルとして設定する[タイトル情報に設定]ボタンが表示されます。  
[タイトル情報に設定]ボタンをクリックするとタイトルにガジェットの種類が入力されます。


#### 7.2.2 複数ドロップ可能にする

ガジェット設定でガジェットを選択すると、[**複数ドロップ可能にする**]チェックボックスが表示されます。

**注意** 以下のガジェットは[**複数ドロップ可能にする**]チェックボックスは表示されません。

* 固定領域
* RSSリーダー
* まとめてRSSリーダー
* ミニブラウザ
* 切り取りミニブラウザ
* ModulePrefs要素singleton属性がtrueのガジェット

[**複数ドロップ可能にする**]設定項目については以下のとおりです。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>複数ドロップ可能にする</td>
            <td>
                メニューからカスタマイズ領域に複数追加可能かどうかを指定します。
                <ul>
                    <li>有効：ガジェットを複数追加可能になります。</li>
                    <li>無効：ガジェットは１つだけ追加可能になります。</li>
                </ul>
            </td>
        </tr>
    </tbody>
</table>


#### 7.2.3 プレビュー

各設定項目の必須項目を入力後[__プレビュー__]ボタンをクリックすることで、設定した内容のガジェットのプレビューが表示されます。


#### 7.2.4 デフォルトに戻す

ガジェット設定項目の下部には、[__デフォルトに戻す__]ボタンが表示されます。各設定項目を、デフォルト値に戻します。デフォルト値はガジェット管理で設定された値が使用されます。


### 7.3 メニュー管理固有のガジェット設定

メニューのガジェット設定で、選択したガジェットの種類によっては特筆すべき仕様があります。


#### 7.3.1 まとめてRSSリーダー

まとめてRSSリーダーの設定項目はRSSリーダーと同じです。  
RSSリーダーと異なる点は、まとめてRSSリーダーはメニューでカスタマイズ領域に追加された場合、設定したメニューの親のメニューがまとめてRSSリーダーとして設定されるRSSリーダーになります。  
例えば、以下のようなメニューツリーが設定されているとします。

* 親メニュー: ＠ITサイト
    * 子メニュー: News(まとめてRSSリーダー)

このとき、子メニュー「News」をパーソナライズエリアにドロップした場合、その親メニューである「＠ITサイト」の子としてRSSリーダーが表示されます。


#### 7.3.2 ガジェット(URL指定)

Webサーバー上に配置してあるガジェットファイルをメニューに直接指定する場合は、[__ガジェット(URL指定)__]を選択します。  
ガジェットの種類で[ガジェット(URL指定)]を選択すると、以下の設定項目が表示されます。

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
                URLは、最大1022バイトまで入力可能です。<br>
                [タイトル情報取得]ボタンをクリックすると、指定したURLのガジェットファイルからタイトルとリンクを取得して、メニューリンク設定の[タイトル]と[タイトルリンク]にセットします。
            </td>
        </tr>
    </tbody>
</table>


#### 7.3.3 ブログパーツ

ブログパーツガジェットは配布されているブログパーツを表示するガジェットです。  
ガジェットの種類で[__ブログパーツ__]を選択すると、以下の設定項目が表示されます。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>HTMLソース</td>
            <td>
                ブログパーツガジェットに表示するブログパーツの内容(HTMLの断片)を設定します。
            </td>
        </tr>
    </tbody>
</table>


### 7.4 公開設定

メニューは、組織や役職などのログインユーザーのロール情報に従って表示/非表示を設定することができます。

* 公開: 全てのユーザーにメニューを公開。
* 非公開(公開のチェックをはずす): 設定した権限を持つユーザーのみにメニューを公開。

各主体者は設定によりHTTPヘッダの値にマッピングされます。

この設定方法は、インストールガイドの <a href="customizing-web-application-module.md#http-header">5 HTTPヘッダをロール情報として定義する</a>を参照してください。  
アクセスコントロールの設定には正規表現を指定します。正規表現は指定した主体者に該当するヘッダの値に対して判定され、有効であれば参照が許可されます。  
アクセスコントロールを複数指定してある場合は、すべての和演算として判定されます。


### 7.5 アラート設定

メニューが新規に追加されると、ユーザーの画面では以下のように新しいメニューが追加されたことを示すメッセージが表示されます。  
アラートの挙動について以下の選択が可能です。

* アラートなし
* メッセージを表示
* 強制的に追加(ガジェットが設定されている場合のみ)

外部メニューサービスが設定されているメニューのアラート設定は、外部メニューサービスで読み込まれるメニュー設定にalert属性が指定していないメニュー項目が追加された場合の動作の設定として使用されます。


### 7.6 ドロップ済みガジェットの更新について

メニューのガジェット設定をメニュー管理画面で変更した際、既にユーザーが当該メニューに設定されているガジェットをパーソナライズエリアにドロップしている場合、そのプロパティの変更をユーザー画面に反映させることができます。  
更新可能なプロパティは、タイトル/タイトルリンク、ガジェットごとのユーザー設定値(UserPref)となります。更新対象のチェックボックスにチェックを入れ、「変更を適用する」実行時にユーザー画面に反映されます。  
タイトルおよびdatatype="hidden"ではないユーザー設定値が強制的に更新された場合、その旨を知らせるメッセージがユーザー画面に表示されます。


## 8 メニュー項目の削除

各メニューの右クリックメニューで[__削除__]を選択するとメニュー削除ダイアログが表示されます。  
[OK]ボタンをクリックするとメニュー項目が削除されます。


## 9 メニューツリーに管理者を設定する

管理者設定項目にて、編集モード時、またはメニューツリー追加時に、そのメニューツリーに対する編集を許可するユーザーを設定することができます。ルートメニューの編集時のみ管理者設定の項目が表示されます。

* コンボボックスには権限「メニューツリー」を持つユーザーIDが全て表示されます。
* メニューツリー管理者は、自身が管理者として割り当てられたメニューツリーのみ参照・編集することができます。


<a name="specify_external_service"></a>
## 10 外部サービスを指定する

本製品はメニューの一部を外部サービス化することができます。  
**注意** 外部サービス化されたメニューの場合URL書き換えロジックが走らない。  
メニュー構成サービスは、以下のスキーマで示されるXMLを応答として返すRESTスタイルのサービスとして作成します。

_メニュー設定ファイルスキーマ_

```
<!ELEMENT sites         (site-top*)>
<!ELEMENT site-top      (site*)>
<!ATTLIST site-top      id          #CDATA      #REQUIRED
                        title       #CDATA      #REQUIRED
                        href        #CDATA      #IMPLIED
>
<!ELEMENT site          (properties, site*)>
<!ATTLIST site          id          #CDATA      #REQUIRED
                        title       #CDATA      #REQUIRED
                        display     #CDATA      #REQUIRED
                        href        #CDATA      #IMPLIED
                        type        #CDATA      #IMPLIED
>
<!ELEMENT properties    (property*)>
<!ELEMENT property      (#PCDATA)>
<!ATTLIST property      name        #CDATA      #REQUIRED>
```

sites要素をルート要素にした場合、1つのサービスで複数のメニューツリーを含めることができます。また、1つのサービスで1つのメニューツリーを定義する場合は、site-topをルート要素としsites要素を省略することができます。以下に各設定項目の説明を示します。

<table>
    <thead>
        <tr>
            <th>設定項目</th><th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <b>sites要素</b>
            </td>
            <td>
                <b>メニュー設定ファイルのルート要素です。複数のメニューツリーを1つのサービスで定義する場合、sites要素に複数のsite-top要素を含めます。</b>
            </td>
        </tr>
        <tr>
            <td>site-top要素</td>
            <td>
                以下のsite-top要素の説明を参照。
            </td>
        </tr>
        <tr>
            <td>
                <b>site-top要素</b>
            </td>
            <td>
                <b>1つのメニューツリー情報を指定します。</b>
            </td>
        </tr>
        <tr>
            <td>id属性</td>
            <td>
                内部的に使用されるIDです。他のメニュー項目のIDと重複しない値を指定する必要があります。<br>
                <strong>注意</strong> メニュー管理で設定されたメニュー項目、および他の外部サービスで定義されたメニュー項目すべてに渡ってidは一意である必要があります。
            </td>
        </tr>
        <tr>
            <td>title属性</td>
            <td>
                メニューに表示されるタイトルです。
            </td>
        </tr>
        <tr>
            <td>href属性</td>
            <td>
                メニューに関連付けられるリンク先のURLを指定します。
            </td>
        </tr>
        <tr>
            <td>site要素</td>
            <td>
                以下のsite要素の説明を参照。
            </td>
        </tr>
        <tr>
            <td>
                <b>site要素</b>
            </td>
            <td>
                <b>メニュー項目の情報を指定します。</b>
            </td>
        </tr>
        <tr>
            <td>id属性</td>
            <td>
                内部的に使用されるIDです。他のメニュー項目のIDと重複しない値を指定する必要があります。<br>
                <b>注意</b> メニュー管理で設定されたメニュー項目、および他の外部サービスで定義されたメニュー項目すべてに渡ってidは一意である必要があります。<br>
                <b>注意</b> idの長さは最大256バイトです。256バイトを超えた場合もメニューは表示されますが、ガジェットアイコンが非表示となります。
            </td>
        </tr>
        <tr>
            <td>title属性</td>
            <td>
                メニューに表示されるタイトルです。
            </td>
        </tr>
        <tr>
            <td>href属性</td>
            <td>
                メニューに関連付けられるリンク先のURLを指定します。
            </td>
        </tr>
        <tr>
            <td>type属性</td>
            <td>
                ガジェットとしてドロップ可能にする場合にガジェットの種類を指定します。<br>
                現在指定できる種類は以下の通りとなります。
                <ul>
                    <li>RssReader</li>
                    <li>MultiRssReader</li>
                    <li>MiniBrowser</li>
                    <li>Gadget</li>
                    <li>指定無し</li>
                <ul>
            </td>
        </tr>
        <tr>
            <td>
                <b>property要素</b>
            </td>
            <td>
                ガジェット固有のプロパティ情報を指定します。
            </td>
        </tr>
        <tr>
            <td>site要素</td>
            <td>
                メニュー階層を再帰的に定義できます。
            </td>
        <tr>
        <tr>
            <td>property要素</td>
            <td>
                RSSリーダーまたはまとめてRSSリーダーに表示するRSSの情報(URL)を指定します。
            </td>
        </tr>
        <tr>
            <td>name属性</td>
            <td>
                RSS情報とのマッピングキーを指定します。現在は"url"を指定します。<br>
                <b>注意</b> urlの長さはtypeに"Gadget"を選択した場合のみ最大1022バイトです。他のtypeを指定した場合に制限はありません。
            </td>
        </tr>
    </tbody>
</table>

以下に、サンプルを示します。

_メニュー設定ファイル記述例_

```
<site-top id="nikkeiBP" title="日経BP" href="http://nikkeibp.jp/">
    <site id="nikkeiBP_all" title="統合" href="http://nikkeibp.jp/"
            type="MultiRssReader">
        <properties>
            <property name="url">http://nikkeibp.jp/index.rdf</property>
        </properties>
    </site>
    <site id="nikkeiBP_news" title="ニュース"
            href="http://nikkeibp.jp/" type="MultiRssReader">
        <properties>
            <property name="url">http://nikkeibp.jp/jp/flash/index.rdf</property>
        </properties>
        <site id="nikkeiBP_management2" title="企業・経営面"
                href="http://nikkeibp.jp/jp/business/" type="MultiRssReader">
            <properties>
                <property name="url">http://nikkeibp.jp/jp/business/index.rdf</property>
            </properties>
        </site>
        <site id="nikkeiBP_itPc" title="IT/PC面"
                href="http://nikkeibp.jp/jp/it/" type="MultiRssReader">
            <properties>
                <property name="url">http://nikkeibp.jp/jp/it/index.rdf</property>
            </properties>
        </site>
    </site>
</site-top>
```


[Properties Settings]: properties-settings.md "プロパティ管理"