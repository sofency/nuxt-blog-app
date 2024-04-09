<template>
  <div class="about-container">
    <NavHeader />
    <CommonHeadImage :message="message" />
    <div class="informations">
      <div class="author-content">
        <div class="author-content-item myInfoAndSayHello">
          <div class="title1">你好，很高兴认识你👋</div>
          <div class="title2">我是<span class="inline-word">肖虎锋</span></div>
          <div class="title1">
            是一名 程序员、<span class="inline-word">独立开发者</span>
          </div>
        </div>
        <div class="aboutSiteTips author-content-item">
          <div class="author-content-item-tips">追求</div>
          <h2>
            源于<br />热爱而去<span class="inline-word">感受</span>
            <div class="mask">
              <span class="scroll-item" data-show="true">学习</span
              ><span class="scroll-item">生活</span
              ><span class="scroll-item">程序</span
              ><span class="scroll-item">体验</span>
            </div>
          </h2>
        </div>
      </div>

      <div class="author-content">
        <div class="author-content-item maxim">
          <div class="author-content-item-tips">座右铭</div>
          <span class="maxim-title"
            ><span style="opacity: 0.6; margin-bottom: 8px"
              >最神奇的魔法就是，</span
            ><span>切实的努力。</span></span
          >
        </div>
        <div class="author-content-item buff">
          <div class="card-content">
            <div class="author-content-item-tips">特长</div>
            <span class="buff-title"
              ><span style="opacity: 0.6; margin-bottom: 8px"
                >写写博客<span class="inline-word">胡乱折腾</span></span
              ><span data-sider-select-id="db505f6e-3367-4710-abe5-e595fbdfd5d1"
                >自驱能力<span
                  class="inline-word"
                  data-sider-select-id="e79b154f-79cc-4578-af4e-368f58e38ed8"
                  >MAX</span
                ></span
              ></span
            >
          </div>
          <div class="card-background-icon">
            <i class="fa-solid fa-dice-d20"></i>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CommonHeadImage from "../components/CommonHeadImage.vue";
export default {
  components: { CommonHeadImage },
  data() {
    return {
      message: "Hello, I'm Sofency",
    };
  },
  mounted() {
    function scrollItems() {
      const items = document.querySelectorAll(".scroll-item");
      const maskHeight = document.querySelector(".mask").offsetHeight;
      let currentItem = Array.from(items).find(
        (item) => item.dataset.show === "true"
      );
      let nextItem = currentItem.nextElementSibling;
      // 如果到达最后一个元素，则回到第一个元素
      if (!nextItem) {
        nextItem = items[0];
      }
      // 隐藏当前元素
      currentItem.dataset.show = "false";
      currentItem.style.top = `${maskHeight}px`;
      // 显示下一个元素
      nextItem.dataset.show = "true";
      nextItem.style.top = "0";
      // 移除上一个元素的data-up属性，避免重复触发
      if (currentItem.dataset.up === "true") {
        delete currentItem.dataset.up;
      }
      // 为下一个元素添加data-up属性，以便知道何时应该滚动到它
      nextItem.dataset.up = "true";
      // 延迟后再次滚动，形成循环效果
      setTimeout(scrollItems, 2000); // 这里的2000毫秒可以根据需要调整
    }
    scrollItems();
  },
  methods: {},
};
</script>

<style scoped lang="less">
.inline-word {
  word-break: keep-all;
  white-space: nowrap;
}

.informations {
  padding-left: 100px;
  padding-right: 100px;
  margin-top: 20px;
  width: 70%;
  margin-left: auto;
  margin-right: auto;

  .author-content {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    width: 100%;
    margin-top: 1rem;

    .author-content-item {
      width: 49%;
      border-radius: 24px;
      background: var(--card-bg);
      border: transparent;
      box-shadow: 0 8px 16px -4px #2c2d300c;
      position: relative;
      padding: 1rem 2rem;
      overflow: hidden;
      transition: all 1s;
    }
    .buff {
      font-size: 36px;
      font-weight: 700;
      line-height: 1.1;
      display: flex;
      align-items: flex-start;
      flex-direction: column;
      justify-content: center;
      background: linear-gradient(120deg, #ff27e8 0, #ff8000 100%);
      color: #fff;
      background-size: 200%;
      animation: gradient 15s ease infinite;
      min-height: 200px;
      height: fit-content;
      width: 59%;

      .card-content {
        display: flex;
        flex-direction: column;
        justify-content: center;

        .buff-title {
          display: flex;
          flex-direction: column;
        }
      }
    }

    .maxim {
      font-size: 36px;
      font-weight: 700;
      line-height: 1.1;
      display: flex;
      align-items: flex-start;
      flex-direction: column;
      justify-content: center;
      width: 39%;

      .maxim-title {
        display: flex;
        flex-direction: column;
      }
    }

    .myInfoAndSayHello {
      display: flex;
      flex-direction: column;
      justify-content: center;
      color: #fff;
      background: linear-gradient(120deg, #5b27ff 0, #00d4ff 100%);
      background-size: 200%;
      animation: gradient 15s ease infinite;
      width: 59%;
      padding: 0;
      padding-left: 2rem;
      position: relative;

      .title1 {
        opacity: 0.8;
        line-height: 1.3;
      }
      .title2 {
        font-size: 36px;
        font-weight: 700;
        line-height: 1.1;
        margin: 0.5rem 0;
      }
    }

    .aboutSiteTips {
      display: flex;
      justify-content: center;
      align-items: flex-start;
      flex-direction: column;
      border: 1px solid;
      width: 39%;

      .mask {
        font-size: 36px;
        height: 36px;
        position: relative;
        overflow: hidden;
        margin-top: 4px;
        .scroll-item {
          display: block;
          position: absolute;
          width: 100%;
          height: 36px;
          line-height: 36px;
          text-align: left;
          transition: top 0.5s ease-in-out; /* 平滑滚动效果 */
        }
        /* 隐藏初始不在视口内的元素 */
        .scroll-item:not([data-show="true"]) {
          top: 120%;
        }
      }
    }
  }
}

.author-content-item-tips {
  opacity: 0.8;
  font-size: 0.6rem;
  margin-bottom: 0.5rem;
}
</style>