# 国際化

infoScoop OpenSourceのコンポーネントを国際化する方法について説明します。

## 1 国際化管理

国際化の管理は、管理画面の国際化管理で各種設定を行えます。

メニューから[**国際化**]を選択します。

## 2 メッセージの国際化

### 2.1 利用可能なコンポーネント

設定可能な以下のコンポーネントについて国際化対応しています。

  * メニュー
  * 検索
  * 画面その他
    * タイトル
    * ヘッダ
    * iFrameToolbar
    * カスタマイズJavaScript
  * ガジェット
  * infoScoop OpenSource本体(本体が利用する国際化メッセージの変更はできません)

### 2.2 ロケールの適用ルール

国際化メッセージはロケールごとに用意する必要があります。

ロケールとは、ユーザーが利用する言語と国の組み合わせで表します。



例) ja(日本語)/jp(日本)、en(英語)/US(米国)



使用するロケールの決定は、ブラウザから送信される「Accept-Language」ヘッダの文字列と比較することによって行われます。

ブラウザの言語設定で複数の言語を指定した場合、先頭に設定した言語が使用されます。

ロケールは言語、国(地域)の順に比較されます。

「Accept-Language」ヘッダで送られるロケールに、適用するロケールかが設定されていない場合、デフォルト設定の言語「ALL(デフォルト)」、国(地
域)「ALL(デフォルト)」が適用されます。

また、選択可能な言語や国(地域)は一意に割り当てられているため設定順序に意味はありません。

### 2.3 国際化メッセージCSVファイルについて

国際化メッセージの管理は、エンコード「Shift_JIS(MS932/Windows-
31J)」で保存されたCSVファイルのインポート/エクスポートによって行います。

国際化メッセージCSV ファイルの書式は、基本的に RFC4180 に準拠します。

CSVファイルには「[国際化メッセージのキー(半角英数およびアンダースコア「_」、最大512バイト)],
[リソースメッセージ(最大2048バイト)]」の順序でメッセージ内容を記述します。

例) "TodoList_title", "TODO リスト"

以下のケースはエラーとなります。

  * 国際化メッセージのキーが空の場合
  * メッセージが空の場合
  * ALL_ALL 以外のロケールでALL_ALLに存在しない国際化メッセージのキーを含むインポートを行った場合

**注意** ALL_ALLに存在して、追加されたロケールに存在しないメッセージは、自動的にALL_ALLのメッセージで補完されます。

## 3 国際化メッセージ管理の操作

<a name='add-delete-locale'></a>
## 3.1 ロケールの追加/削除

[**ロケールの追加**]をクリックするとロケールの追加ウィンドウが表示されます。

ロケールの設定内容は以下の通りです。

<table>
    <thead>
        <tr>
            <th>設定項目</th>
            <th>説明</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>国</td>
            <td>国を選択します。</td>
        </tr>
        <tr>
            <td>言語</td>
            <td>言語を選択します。</td>
        </tr>
     </tbody>
</table>

[**追加**]ボタンをクリックすることでロケールが追加されます。

ロケールの削除は各行の![Trash icon]アイコンをクリックすることで行います。

<a name='import-export-locale'></a>
### 3.2 ロケールのインポート/エクスポート

[**インポート**]をクリックすると国際化メッセージインポートダイアログが表示されます。

インポートモードは以下の2種類があります。

```
全置換：該当ロケールのメッセージデータを全て削除後にインポートを実行します。

差分：該当ロケールのメッセージデータを削除せずにインポートを実行します。
```

以下のケースはエラーとなります。

  * 国際化メッセージのキーが空の場合
  * メッセージが空の場合
  * ALL_ALL 以外のロケールでALL_ALLに存在しない国際化メッセージのキーを含むインポートを行った場合

**注意** デフォルトロケール(ALL_ALL)の全置換を行った場合、デフォルトロケールの存在しなくなった他ロケールのメッセージは削除されます。

登録されている国際化メッセージを確認または、編集する場合は[**エクスポート**]をクリックすることで、現在のメッセージ一覧をエクスポートすることができます
。

## 4 国際化メッセージの適用

### 4.1 メニューへの適用

「メニュー」タイプの項目に国際化メッセージをインポートします。

[**メニュー**]タブからメニュータイトルを「 **%{国際化の ID}**
」と設定します。メニューの設定に関しては[メニュー管理][Menu Settings]を参照ください。

**注意** メニュータイトルに指定可能な最大文字数は80文字までです。つまり、指定できるメッセージのIDは77文字以下に設定する必要があります。また、変換される
メッセージについても80文字を超えている場合、メニュー表示時に自動的に切り捨てられます。

### 4.2 検索への適用

「検索フォーム」タイプの項目に国際化メッセージをインポートします。

[**検索フォーム**]タブから検索サイトのタイトルを「 **%{国際化の ID}** 」と設定します。検索フォームの設定に関しては[検索サイト管理][Search Form Administration]を参照ください。

**注意** 検索サイトのタイトルに指定可能な最大文字数は128文字までです。つまり、指定できるメッセージのIDは125文字以下に設定する必要があります。検索設定
に使用するメッセージにはXML予約文字「<」、「>」、「&」、「'」、「"」は利用できません。

### 4.3 画面その他への適用

「画面その他」タイプの項目に国際化メッセージをインポートします。

[**レイアウト**]タブのサイドバーから[**画面その他**]を選択し、titleを「**%{国際化の ID}**」と設定します。画面その他の設定に関
しては[画面その他][Other Layout]を参照ください．

**注意** title、header、iFrameToolBarに使用するメッセージには、XML予約文字「<」、「>」、「&」、「'」、「"」は利用できません。
また、JavaScriptに使用するメッセージは、適用後にJavaScriptの構文エラーとならないよう注意する必要があります。

## 5 休日の国際化

休日は以下のガジェットに利用されます。

  * カレンダー - 休日を表示します。
  * RSSリーダー - 新着アイコンを表示するかどうかの判定に利用されます。

休日は、国際化メッセージと同様にロケールごとに用意します。

## 6 休日設定管理の操作

### 6.1 休日設定ファイルについて

休日設定ファイルはiCalendar形式で定義します。iCalendar形式についてはRFC2445の「Internet Calendaring and
Scheduling Core Object Specification」を参照してください。

infoScoop OpenSourceのインストール時に含まれている休日設定ファイルは日本のみで、デフォルトの「ALL_ALL」に設定されています。

また、アップロード可能なiCalendarファイルの文字コードはUTF-8です。

### 6.2 休日設定の追加/削除

休日設定のロケール追加/削除は、<a href="#add-delete-locale">3.1 ロケールの追加/削除</a>と同様の手順で行います。

### 6.3 休日設定のインポート/エクスポート

休日設定のインポート/エクスポートは、<a href="#import-export-locale">3.2 ロケールのインポート/エクスポート</a>と同様の手順で行います。


[Menu Settings]: menu-settings.md "メニュー管理"
[Search Form Administration]: search-form-administration.md "検索サイト管理"
[Other Layout]: other-layout.md "画面その他"
[Trash icon]: ../../images/trash.gif "ごみ箱"