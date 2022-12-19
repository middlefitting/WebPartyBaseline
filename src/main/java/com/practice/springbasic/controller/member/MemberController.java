package com.practice.springbasic.controller.member;

import com.practice.springbasic.controller.member.vo.RequestLoginMemberForm;
import com.practice.springbasic.controller.member.vo.RequestMemberForm;
import com.practice.springbasic.controller.member.vo.ResponseMemberForm;
import com.practice.springbasic.controller.utils.form.SuccessReturnForm;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import static com.practice.springbasic.config.error.ErrorMessage.PasswordEmpty;
import static com.practice.springbasic.config.error.ErrorMessage.PasswordLen;

public interface MemberController {
    ResponseEntity<ResponseMemberForm> joinMember(HttpServletResponse response, @Valid RequestMemberForm requestUserForm, BindingResult bindingResult);

    ResponseEntity<ResponseMemberForm> loginMember(HttpServletResponse response, @Valid RequestLoginMemberForm requestLoginMemberForm, BindingResult bindingResult);
    ResponseEntity<ResponseMemberForm> getMember(HttpServletRequest request, Long memberId);

    ResponseEntity<ResponseMemberForm> updateMember(HttpServletRequest request, Long memberId, @Valid RequestMemberForm requestMemberForm, BindingResult bindingResult);

    ResponseEntity<SuccessReturnForm> deleteMember(
            HttpServletRequest request,
            Long memberId,
            @NotEmpty(message = PasswordEmpty)
            @Length(min=10, max=20, message = PasswordLen)
            String password);

    ResponseEntity<SuccessReturnForm> nicknameDuplicateCheck(@NotEmpty @Length(min=4, max=20, message = "닉네임은 4자에서 20자 사이로 입력하세요!") String nickname);

    ResponseEntity<SuccessReturnForm> emailDuplicateCheck(@NotEmpty @Email String email);
}
