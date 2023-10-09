import openai
from flask import Flask, request, jsonify

# Team Service Key
openai.api_key = "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"

app = Flask(__name__)

@app.route('/api/v1/openai/question', methods=['POST'])
def answer_question_api():
    user_input = request.form.get('question')
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            { 
                "role": "system",
                "content": """너는 최고의 금융전문가이다. 주식, 증권에 대해서 굉장히 잘 알고 있는 전문가이다.
                  다음에 주어지는 질문에 답해줘.
                  다만, 너의 대답을 들을 사람은 금융, 주식, 증권에 대한 초보자이므로 쉽고 친절하게 알려줘야해"""
            },
            { 
                "role": "user",
                "content": user_input
            }
        ],
        max_tokens=100
    )    
    answer = response['choices'][0]['message']['content']
    return jsonify({'answer': answer})

@app.route('/api/v1/openai', methods=['POST'])
def analysis_data_api():
    financial_data = request.json.get('data')
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            { 
                "role": "system",
                "content": """너는 최고의 금융전문가이다. 주식, 증권에 대해서 굉장히 잘 알고 있는 전문가이다.
                  또한 너는 차트와 재무재표 분석에 능하다. 다음에 주어지는 데이터를 분석한 결과를 알려줘."""
            },
            { 
                "role": "user",
                "content": financial_data
            }
        ],
        max_tokens=50
    )    
    answer = response['choices'][0]['message']['content']
    return jsonify({'answer': answer})

@app.route('/api/v1/openai', methods=['POST'])
def recommand_similar_concepts_api():
    user_word_data = request.json.get('words')
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            { 
                "role": "system",
                "content": """너는 최고의 금융전문가이다. 주식, 증권에 대해서 굉장히 잘 알고 있는 전문가이다.
                  다음에 주어지는 단어 데이터들과 유사한 단어들을 10가지 더 골라서 뜻과 함께 알려줘.
                  다만, 너의 대답을 들을 사람은 금융, 주식, 증권에 대한 초보자이므로 쉽고 친절하게 알려줘야해"""
            },
            { 
                "role": "user",
                "content": user_word_data
            }
        ],
        max_tokens=50
    )    
    answer = response['choices'][0]['message']['content']
    return jsonify({'answer': answer})

@app.route('/api/v1/test', methods=['POST'])
def test_api():
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            { 
                "role": "system",
                "content": """너는 최고의 금융전문가이다. 주식, 증권에 대해서 굉장히 잘 알고 있는 전문가이다.
                  다음에 주어지는 단어 데이터들과 유사한 단어들을 10가지 더 골라서 뜻과 함께 알려줘.
                  다만, 너의 대답을 들을 사람은 금융, 주식, 증권에 대한 초보자이므로 쉽고 친절하게 알려줘야해"""
            },
            { 
                "role": "user",
                "content": "코스피가 뭐야?"
            }
        ],
        max_tokens=200
    )    
    answer = response['choices'][0]['message']['content']
    return jsonify({'answer': answer})


if __name__ == '__main__':
    app.run(host='127.0.0.1', port=5000, debug=True)
