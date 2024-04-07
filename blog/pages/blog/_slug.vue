<template>
  <div class="article-container">
    <NavHeader />
    <div class="article-view">
      <CommonHeadImage :message="article.title" />
      <Row type="flex" class="article-content">
        <Col :span="0" :lg="4" class="article-info">浏览数据信息</Col>
        <Col :span="24" :lg="16" class="article">
          <div class="article-body">
            <div v-html="parsedMarkdown"></div>
          </div>
          <BlogComment :comments="comments" />
        </Col>
      </Row>
    </div>
    <Fotter />
  </div>
</template>

<script>
import NavHeader from "../../components/NavHeader.vue";
import BlogComment from "../../components/BlogComment.vue";
import Fotter from "../../components/Fotter.vue";
import $ from "jquery";
import { Row, Col } from "ant-design-vue";
import handleScroll from "../../static/slip";

export default {
  async asyncData({ $axios, params }) {
    const responseData = await $axios({
      url: `/api/blog/detail/${params.slug}`,
    });
    return {
      article: responseData.data.data.blog,
      comments: responseData.data.data.comments,
    };
  },
  components: { NavHeader, BlogComment, Row, Col, Fotter },
  computed: {
    parsedMarkdown() {
      return this.$md.render(this.article.content);
    },
  },

  head() {
    return {
      title: this.article.title,
      meta: [
        {
          hid: "title",
          name: "title",
          content: this.article.title,
        },
        {
          hid: "og:keywords",
          property: "og:keywords",
          content: this.article.tag,
        },
        // 这里可以添加更多的meta标签根据需求
      ],
    };
  },
  methods: {
    handleDoubleClick() {
      console.log("sasa");
    },
  },

  mounted() {
    window.addEventListener("scroll", handleScroll);
    // 复制内容追加版权信息
    $(document).on("copy", function () {
      var selectedText = window.getSelection().toString();
      if (selectedText.length > 0) {
        var copyrightText = "版权所有 © 2023 www.sofency.cn";
        var copiedContent = selectedText + "\n" + copyrightText;
        var clipboardData =
          event.clipboardData ||
          window.clipboardData ||
          event.originalEvent.clipboardData;
        clipboardData.setData("text", copiedContent);
        event.preventDefault();
      }
    });
  },
};
</script>

<style scoped lang="less">
.article-content {
  padding: 0px 100px;
  margin-left: auto;
  margin-right: auto;
  padding-top: 20px;

  .article {
    article {
      margin-bottom: 30px;
    }
  }
}
</style>


